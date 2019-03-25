package com.pdq.pedido.business.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.bce.domain.Result;
import com.google.common.base.Strings;
import com.pdq.pedido.bean.aprovacao.RegraAprovacaoValidator;
import com.pdq.pedido.dao.impl.ControleAprovacaoDAO;
import com.pdq.pedido.dao.impl.FluxoPedidoDAO;
import com.pdq.pedido.dao.impl.RegraDAO;
import com.pdq.pedido.dao.impl.StatusControleAprovacaoDAO;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.CorPedido;
import com.pdq.pedido.domain.FluxoPedido;
import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.Regra;
import com.pdq.pedido.domain.RegraAprovacaoCor;
import com.pdq.pedido.domain.RegraAprovacaoPrazo;
import com.pdq.pedido.domain.StatusControleAprovacao;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.pedido.helper.FluxoPedidoHelper;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.helper.RegraHelper;
import com.pdq.pedido.helper.StatusControleAprovacaoHelper;
import com.pdq.pedido.helper.StatusPedidoHelper;

/**
 * @author Bruno Holanda Muralis Acessoria e Tecnologia Ltda.
 * @date 8 de mar de 2019
 *
 */
@Component
public class ComputeApprovementList implements IStrategy<PedidoHelper>, ApplicationContextAware {

	final static Logger LOG = LoggerFactory.getLogger(ComputeApprovementList.class);

	@Autowired
	private ControleAprovacaoDAO controleAprovacaoDao;
	@Autowired
	private FluxoPedidoDAO fluxoPedidoDao;
	@Autowired
	private RegraDAO regraDao;
	@Autowired
	private StatusControleAprovacaoDAO statusControleAprovacaoDao;
	private StatusControleAprovacao statusPendente;
	private Map<String, RegraAprovacaoValidator> beansRegrasAprovacao;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if (aEntity != null) {
			statusPendente = statusControleAprovacaoDao.findById(StatusControleAprovacaoHelper.ID_PENDENTE);
			List<ControleAprovacao> listaControleAprovacao = new ArrayList<>();
			List<PedidoItem> listaPedidoItem = aEntity.getListPedidoItem();
			LOG.info("Chamada do método compute da strategy ComputeApprovementList.");
			if (!compute(listaControleAprovacao, aEntity, listaPedidoItem, aEntity.getStatusPedido())) {
				aCase.getResult()
						.setMessage("O fluxo de aprovação computado não termina em status IMPLANTADO ou APROVADO.");
				aCase.getResult().setError();
				aCase.suspendExecution();
			} else if (CollectionUtils.isEmpty(listaControleAprovacao)) {
				aCase.getResult().setMessage("O pedido não se aplica a nenhuma regra cadastrada.");
				aCase.getResult().setError();
				aCase.suspendExecution();
			} else {
				controleAprovacaoDao.saveAll(listaControleAprovacao);
				
			}

			return;
		}
		aCase.getResult().setMessage("Entidade Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}

	private Boolean compute(List<ControleAprovacao> listaControleAprovacao, Pedido pedido,
			List<PedidoItem> listaPedidoItem, StatusPedido statusPedido) {

		// Signal that a end status was found in the flow
		if (StatusPedidoHelper.isEndStatus(statusPedido)) {
			return true;
		}
		Filter<FluxoPedidoHelper> fluxoFilter = new Filter<>();
		FluxoPedidoHelper fluxoPedidoHelper = new FluxoPedidoHelper();
		fluxoPedidoHelper.setStatusPedidoDe(statusPedido);
		fluxoFilter.setEntity(fluxoPedidoHelper);
		StatusPedido statusPedidoPara;
		RegraHelper regraHelper = new RegraHelper();
		List<Regra> listRegras;
		Filter<RegraHelper> regraFilter = new Filter<>();
		Boolean validBean, foundValidColor, foundValidTerm, foundColorRule, foundTermRule;

		// Find flows that start with the current status
		
		List<FluxoPedido> fluxos = fluxoPedidoDao.findByFluxoPedidoByIdStatusPedidoDe(fluxoFilter)
				.collect(Collectors.toList());

		for (FluxoPedido fluxoPedido : fluxos) {

			validBean = true;
			foundColorRule = false;
			foundValidColor = false;
			foundTermRule = false;
			foundValidTerm = false;
			statusPedidoPara = fluxoPedido.getStatusPedidoPara();
			regraHelper.setIdStatusPedido(statusPedidoPara.getId());
			regraFilter.setEntity(regraHelper);
			listRegras = regraDao.findRegrasByIdStatusPedido(regraFilter).collect(Collectors.toList());

			// Verify status appliance to order or budget
			if (!verifyApplianceToOrderType(pedido.getOrcamento(), fluxoPedido))
				continue;

			// Verify bean
			if (!Strings.isNullOrEmpty(fluxoPedido.getBeanValidacao())) {
				validBean = validateBean(fluxoPedido.getBeanValidacao(), pedido, listaPedidoItem);
				if (validBean) {
					validBean = addBeanRule(fluxoPedido.getBeanValidacao(), listaControleAprovacao, statusPedidoPara,
							pedido);
				}
			}

			for (Regra regra : listRegras) {

				// Color rule
				if (!foundValidColor) {
					if (validateColorRule(regra)) {
						foundColorRule = true;
						foundValidColor = validateColor(regra, listaPedidoItem);
						if (foundValidColor) {
							listaControleAprovacao
									.add(new ControleAprovacao(statusPedidoPara, regra, pedido, statusPendente));
						}
					}
				}

				// Payment term rule
				if (validateTermRule(regra)) {
					foundTermRule = true;
					foundValidTerm = validateTerm(regra, pedido, listaPedidoItem);
					if (foundValidTerm) {
						listaControleAprovacao
								.add(new ControleAprovacao(statusPedidoPara, regra, pedido, statusPendente));
					}
				}
			}
			// Verify if there is valid rules. If don't find rules, it will skip
			// to the next status.
			if (foundColorRule == foundValidColor && validBean && foundTermRule == foundValidTerm) {
				LOG.info(pedido.getCodSap() + " - De: " + fluxoPedido.getStatusPedidoDe().getDescricaoStatus()
						+ " Para: " + statusPedidoPara.getDescricaoStatus());
				return compute(listaControleAprovacao, pedido, listaPedidoItem, statusPedidoPara);
			}

		}
		return false;
	}

	private Boolean validateColorRule(Regra regra) {
		if (regra instanceof RegraAprovacaoCor) {
			return true;
		}
		return false;
	}

	private Boolean validateColor(Regra regra, List<PedidoItem> listaPedidoItem) {
		RegraAprovacaoCor regraCor = (RegraAprovacaoCor) regra;
		CorPedido cor = regraCor.getCorPedido();
		Double totalFobPedido = 0d;
		Double totalItem;
		Double totalCor = 0d;
		for (PedidoItem pedidoItem : listaPedidoItem) {
			totalItem = pedidoItem.getValorUnitFob() * pedidoItem.getQuantidade();
			totalFobPedido += totalItem;
			if (pedidoItem.getCorPedido().getId().equals(cor.getId()))
				totalCor += totalItem;
		}
		double porcentagemCor = totalCor * 100 / totalFobPedido;
		if (porcentagemCor > regraCor.getPercentualInicio() && porcentagemCor <= regraCor.getPercentualFim()) {
			return true;
		}
		return false;
	}

	private Boolean verifyApplianceToOrderType(Boolean orcamento, FluxoPedido fluxoPedido) {
		if (orcamento) {
			if (fluxoPedido.getAplicaOrcamento())
				return true;
		} else if (fluxoPedido.getAplicaPedido()) {
			return true;
		}
		return false;

	}

	private Boolean validateBean(String beanValidacao, Pedido pedido, List<PedidoItem> listaPedidoItem) {

		RegraAprovacaoValidator regraAprovacaoValidator = beansRegrasAprovacao.get(beanValidacao);
		Result result = regraAprovacaoValidator.validar(pedido, listaPedidoItem);
		Optional<Boolean> valid = result.getEntity();
		return (Boolean) valid.get();
	}

	private Boolean addBeanRule(String beanValidacao, List<ControleAprovacao> listaControleAprovacao,
			StatusPedido statusPedidoPara, Pedido pedido) {
		RegraAprovacaoValidator beanValidator = beansRegrasAprovacao.get(beanValidacao);
		String descricao = beanValidator.getRegraDescricao();
		Regra regraBean = beanValidator.getRegra(descricao);
		if (null != regraBean) {
			listaControleAprovacao.add(new ControleAprovacao(statusPedidoPara, regraBean, pedido, statusPendente));
			return true;
		}
		return false;
	}

	private Boolean validateTermRule(Regra regra) {
		if (regra instanceof RegraAprovacaoPrazo) {
			RegraAprovacaoPrazo regraPrazo = (RegraAprovacaoPrazo) regra;
			if (regraPrazo.getAtivo() && LocalDate.now().isAfter(regraPrazo.getDataVigenciaInicio())
					&& LocalDate.now().isBefore(regraPrazo.getDataVigenciaFim())) {
				return true;
			}
		}
		return false;
	}

	private Boolean validateTerm(Regra regra, Pedido pedido, List<PedidoItem> listaPedidoItem) {

		RegraAprovacaoPrazo regraPrazo = (RegraAprovacaoPrazo) regra;
		for (PedidoItem pedidoItem : listaPedidoItem) {
			LinhaProduto linhaProduto = pedidoItem.getProdutoPrecoRegras().getLinhaProduto();
			// Verify product line before perform term calculation
			if (regraPrazo.getLstLinhaProduto().contains(linhaProduto)) {
				Integer periodo = pedidoItem.getCondicaoPagamento().getDiasPagamento() == null ? 0
						: Integer.valueOf(pedidoItem.getCondicaoPagamento().getDiasPagamento());
				Instant dIni = pedido.getDtCriacaoPedido();
				Instant dFim;
				// LocalDate dIni = LocalDate.from(pedido.getDtCriacaoPedido());
				// LocalDate dFim;
				if (pedidoItem.getDataPagamento() != null) {
					dFim = Instant.from(
							pedidoItem.getDataPagamento().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant());
				} else if (pedidoItem.getDataFaturamento() != null) {
					dFim = pedidoItem.getDataFaturamento();
				} else {
					return false;
				}

				int prazoPagamento = (int) ChronoUnit.DAYS.between(dIni, dFim);
				prazoPagamento += periodo;

				if (prazoPagamento >= regraPrazo.getPrazoPagamentoInicio()
						&& prazoPagamento <= regraPrazo.getPrazoPagamentoFim()) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		beansRegrasAprovacao = applicationContext.getBeansOfType(RegraAprovacaoValidator.class);
	}

}

package com.pdq.pedido.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.google.common.base.Strings;
import com.pdq.pedido.dao.impl.ControleAprovacaoDAO;
import com.pdq.pedido.dao.impl.FluxoPedidoDAO;
import com.pdq.pedido.dao.impl.StatusPedidoRegraDAO;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.CorPedido;
import com.pdq.pedido.domain.FluxoPedido;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.Regra;
import com.pdq.pedido.domain.RegraAprovacaoCor;
import com.pdq.pedido.domain.StatusControleAprovacao;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.pedido.domain.StatusPedidoRegra;
import com.pdq.pedido.helper.FluxoPedidoHelper;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.helper.StatusControleAprovacaoHelper;
import com.pdq.pedido.helper.StatusPedidoRegraHelper;
import com.pdq.utils.IRepository;

/**
 * @author Bruno Holanda
 * Muralis Acessoria e Tecnologia Ltda.
 * @date 8 de mar de 2019
 *
 */
@Component
public class ComputeApprovementList implements IStrategy<PedidoHelper> {
	
	@Autowired private ControleAprovacaoDAO daoControleAprovacao;
	
	@Autowired private FluxoPedidoDAO daoFluxoPedido;
	
	@Autowired private StatusPedidoRegraDAO daoStatusPedidoRegra;
	
	@Autowired private IRepository<StatusControleAprovacao, Long> statusControleAprovacaoRepository;
	
	@Autowired private StatusControleAprovacao statusPendente = statusControleAprovacaoRepository.findById(StatusControleAprovacaoHelper.ID_PENDENTE).get();

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if(aEntity != null) {
			List<ControleAprovacao> listaControleAprovacao = new ArrayList<>();
			List<PedidoItem> listaPedidoItem = aEntity.getListPedidoItem();
			compute(listaControleAprovacao, aEntity, listaPedidoItem, aEntity.getStatusPedido());
			if (CollectionUtils.isEmpty(listaControleAprovacao)){
				aCase.getResult().setMessage("O pedido não se aplica a nenhuma regra cadastrada.");
				aCase.getResult().setError();
				aCase.suspendExecution();
				return;
			}
			daoControleAprovacao.saveAll(listaControleAprovacao);
			return;
		}
		aCase.getResult().setMessage("Entidade Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}

	private void compute(List<ControleAprovacao> listaControleAprovacao, Pedido pedido,
			List<PedidoItem> listaPedidoItem, StatusPedido statusPedido) {
		
		Filter<FluxoPedidoHelper> fluxoFilter = new Filter<>();
		FluxoPedidoHelper fluxoPedidoHelper = new FluxoPedidoHelper();
		fluxoPedidoHelper.setStatusPedidoDe(statusPedido);
		fluxoFilter.setEntity(fluxoPedidoHelper);
		StatusPedido statusPedidoPara;
		StatusPedidoRegraHelper statusPedidoRegraHelper = new StatusPedidoRegraHelper();
		List<StatusPedidoRegra> statusPedidoRegras;
		Filter<StatusPedidoRegraHelper> statusPedidoRegraFilter = new Filter<>();
		Boolean validBean,
				foundValidColor,
				foundValidTerm;
		
		// Find flows that starts with the current status
		List<FluxoPedido> fluxos = daoFluxoPedido.findByFluxoPedidoByIdStatusPedidoDe(fluxoFilter).collect(Collectors.toList());
		
		for (FluxoPedido fluxoPedido : fluxos) {
			
			validBean = true;
			foundValidColor = false;
			foundValidTerm = false;
			statusPedidoPara = fluxoPedido.getStatusPedidoPara();
			statusPedidoRegraHelper.setStatusPedido(statusPedidoPara);
			statusPedidoRegraFilter.setEntity(statusPedidoRegraHelper);
			statusPedidoRegras = daoStatusPedidoRegra.findRegrasByStatusPedido(statusPedidoRegraFilter).collect(Collectors.toList());

			// Verify status appliance to order or budget
			if (!verifyApplianceToOrderType(pedido.getOrcamento(), statusPedidoPara))
				continue;
			
			// Verify bean
			if (!Strings.isNullOrEmpty(fluxoPedido.getBeanValidacao())){
				validBean = validateBean(fluxoPedido.getBeanValidacao(), pedido, listaPedidoItem);
			}
			
			for (StatusPedidoRegra statusPedidoRegra : statusPedidoRegras) {
                Regra regra = statusPedidoRegra.getRegra();

                // Color rule
                if ( !foundValidColor ) {
                	foundValidColor = validateColor(regra, listaPedidoItem);
                	if (foundValidColor) {
                		listaControleAprovacao.add(new ControleAprovacao(statusPedidoPara, regra, pedido, statusPendente));
                	}
                }
                
                // Payment term rule
                if ( !foundValidTerm ) {
                	foundValidColor = validateTerm(regra, listaPedidoItem);
                	if (foundValidTerm) {
                		listaControleAprovacao.add(new ControleAprovacao(statusPedidoPara, regra, pedido, statusPendente));
                	}
                }
            }
			if (foundValidColor && validBean) {
				compute(listaControleAprovacao, pedido, listaPedidoItem, statusPedidoPara);
				return;
			}
				
		}
	}

	private Boolean validateColor(Regra regra, List<PedidoItem> listaPedidoItem) {
		if (regra instanceof RegraAprovacaoCor) {
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
			if ( porcentagemCor > regraCor.getPercentualInicio() &&
					porcentagemCor <= regraCor.getPercentualFim()) {
	            return true;
	        }
		}
		return false;
	}

	private boolean verifyApplianceToOrderType(Boolean orcamento, StatusPedido statusPedidoPara) {
		if (orcamento)
			if (statusPedidoPara.getAplicaOrcamento())
				return true;
		else
			if (statusPedidoPara.getAplicaPedido())
				return true;
		return false;
		
	}

	private Boolean validateBean(String beanValidacao, Pedido pedido, List<PedidoItem> listaPedidoItem) {
		// TODO: implement beans logic
		return null;
	}
	
	private Boolean validateTerm(Regra regra, List<PedidoItem> listaPedidoItem) {
		return false;
		
	}
	

}

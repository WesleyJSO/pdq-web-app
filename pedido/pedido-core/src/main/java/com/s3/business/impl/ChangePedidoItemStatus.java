package com.s3.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.RegraAprovacaoPrazo;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.pedido.domain.Usuario;
import com.s3.dao.impl.LinhaProdutoDAO;
import com.s3.dao.impl.StatusPedidoDAO;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.CorPedidoHelper;
import com.s3.helper.LinhaProdutoHelper;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusControleAprovacaoHelper;
import com.s3.helper.StatusPedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 21 de abr de 2019
 *
 */
@Component
public class ChangePedidoItemStatus implements IStrategy<PedidoHelper> {

	final static Logger LOG = LoggerFactory.getLogger(ChangePedidoItemStatus.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private LinhaProdutoDAO linhaProdutoDAO;

	@Autowired
	private StatusPedidoDAO statusPedidoDAO;

	private StatusPedido finalStatusAprovacao;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {

		Optional<Pedido> optional = aCase.getResult().getEntity();
		Pedido pedido = optional.get();
		Optional<Stream<ControleAprovacao>> approvedOptional = aCase.getResult()
				.getEntity("changeStatusControleAprovacaoResult");
		List<ControleAprovacao> listApproved = approvedOptional.isPresent()
				? approvedOptional.get().collect(Collectors.toList()) : Collections.emptyList();
		List<ControleAprovacao> listControleAprovacao = null;
		finalStatusAprovacao = findFinalStatus(pedido);

		if (!CollectionUtils.isEmpty(listApproved)) {
			listControleAprovacao = aEntity.getListControleAprovacao();
			Optional<Stream<RegraAprovacaoPrazo>> regraAprovacaoPrazoOptional = aCase.getResult()
					.getEntity("findTermRulesResult");
			List<RegraAprovacaoPrazo> listRegra = regraAprovacaoPrazoOptional.get().collect(Collectors.toList());
			Usuario usuario = usuarioDAO.getLoggedUser();
			List<PedidoItem> itensToAprove = pedido.getListPedidoItem();
			for (ControleAprovacao controle : listApproved) {
				itensToAprove = getPedidoItensParaAprovacao(controle, usuario, itensToAprove, listRegra);
				changePedidoItemStatus(itensToAprove, controle, listControleAprovacao);
			}
			aCase.getResult().addEntity("findTermRulesResult", listRegra.stream());
		} else {
			Optional<Stream<ControleAprovacao>> controleAprovacaoOptional = aCase.getResult().getEntities();
			listControleAprovacao = controleAprovacaoOptional.get().collect(Collectors.toList());
			StatusPedido newStatus = findStatus(listControleAprovacao, pedido);
			pedido.getListPedidoItem().forEach(item -> {
				item.setStatusAprovacao(newStatus);
			});
			aCase.getResult().addEntities(listControleAprovacao.stream());
		}
		aCase.getResult().addEntity("changeStatusControleAprovacaoResult", listApproved.stream());
		pedido.setListControleAprovacao(listControleAprovacao);
		aCase.getResult().addEntity(pedido);
	}

	public List<PedidoItem> getPedidoItensParaAprovacao(ControleAprovacao controle, Usuario usuario,
			List<PedidoItem> lstPedidoItem, List<RegraAprovacaoPrazo> listRegra) {
		long idStatus = controle.getStatusPedido().getId();
		List<PedidoItem> itensToAprove = new ArrayList<>();

		if (controle.getStatusPedido().getId().equals(StatusPedidoHelper.ID_STATUS_APROVACAO_DIRETOR_COMERCIAL)
				|| controle.getStatusPedido().getId().equals(StatusPedidoHelper.ID_STATUS_APROVACAO_SUPERA)
				|| controle.getStatusPedido().getId().equals(StatusPedidoHelper.ID_STATUS_APROVACAO_BONIFICACAO_GP)
				|| controle.getStatusPedido().getId().equals(StatusPedidoHelper.ID_STATUS_APROVACAO_SUPERA_GMT)
				|| controle.getStatusPedido().getId()
						.equals(StatusPedidoHelper.ID_STATUS_APROVACAO_BONIFICACAO_DIRETOR)) {
			LinhaProdutoHelper lpHelper = new LinhaProdutoHelper();
			lpHelper.setIdUsuario(usuario.getId());
			Filter<LinhaProdutoHelper> filterLinhaProduto = new Filter<>();
			filterLinhaProduto.setEntity(lpHelper);
			List<LinhaProduto> lstLinhaUsuario = linhaProdutoDAO.findLinhaProdutoByIdUsuario(filterLinhaProduto)
					.collect(Collectors.toList());
			if (lstLinhaUsuario != null && !lstLinhaUsuario.isEmpty()) {
				for (PedidoItem pi : lstPedidoItem) {

					if (StatusPedidoHelper.ID_STATUS_APROVACAO_DIRETOR_COMERCIAL.equals(idStatus)
							&& pi.getCorPedido().getId().equals(CorPedidoHelper.ID_PRETO)) {
						itensToAprove.add(pi);
						continue;
					}

					if (lstLinhaUsuario.contains(pi.getProdutoPrecoRegras().getLinhaProduto())) {
						itensToAprove.add(pi);
						continue;
					}
				}
			}
		} else if (controle.getStatusPedido().getId().equals(StatusPedidoHelper.ID_STATUS_APROVACAO_PRAZO)) {
			for (PedidoItem pi : lstPedidoItem) {

				for (RegraAprovacaoPrazo regraAprovacaoPrazo : listRegra) {
					if (usuario.getId().equals(regraAprovacaoPrazo.getAprovador().getId()) && regraAprovacaoPrazo
							.getLstLinhaProduto().contains(pi.getProdutoPrecoRegras().getLinhaProduto())) {
						itensToAprove.add(pi);
						LOG.info("Status " + controle.getStatusPedido().getDescricaoStatus() + " do item "
								+ pi.getProdutoPrecoRegras().getProduto().getDesProduto() + " aprovado por "
								+ usuario.getLogin() + " por meio da regra de prazo entre "
								+ regraAprovacaoPrazo.getDataVigenciaInicio() + " e "
								+ regraAprovacaoPrazo.getDataVigenciaFim() + " dias.");
						continue;
					}
				}

				if (listRegra.isEmpty()) {
					itensToAprove.add(pi);
				}
			}
		} else {
			itensToAprove.addAll(lstPedidoItem);
		}
		return itensToAprove;
	}

	private void changePedidoItemStatus(List<PedidoItem> itensToAprove, ControleAprovacao controle,
			List<ControleAprovacao> listControleAprovacao) {
		itensToAprove.forEach(item -> {
			ControleAprovacao controleAprovacao = listControleAprovacao.stream()
					.filter(ca -> (ca.getStatusPedido().getOrdem() > controle.getStatusPedido().getOrdem()
							&& !ca.getApproved()) || !ca.getApproved())
					.findFirst().orElse(null);
			if (null != controleAprovacao)
				item.setStatusAprovacao(controleAprovacao.getStatusPedido());
			else
				item.setStatusAprovacao(finalStatusAprovacao);
		});

	}

	/**
	 * @param pedido
	 * @return the final status of the order or budget
	 */
	private StatusPedido findFinalStatus(Pedido pedido) {
		return pedido.getOrcamento()
				? statusPedidoDAO.findById(StatusPedidoHelper.ID_STATUS_APROVADO, pedido.getStatusPedido()).get()
				: statusPedidoDAO.findById(StatusPedidoHelper.ID_STATUS_IMPLANTADO, pedido.getStatusPedido()).get();
	}

	/**
	 * @param listControleAprovacao
	 * @param pedido
	 * @return the proper status to the order or budget
	 */
	private StatusPedido findStatus(List<ControleAprovacao> listControleAprovacao, Pedido pedido) {
		// if any of the active approvals were disapproved, return the proper
		// disapprove status
		for (ControleAprovacao ca : listControleAprovacao) {
			if (ca.isAtivo()) {
				if (ca.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_REPROVADO)) {
					Long idDisaprove;
					if (!pedido.getOrcamento())
						idDisaprove = StatusPedidoHelper.ID_STATUS_NAO_APROVADO;
					else
						idDisaprove = StatusPedidoHelper.ID_STATUS_RECUSADO;
					return statusPedidoDAO.findById(idDisaprove, ca.getStatusPedido()).get();
				} else if (ca.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_CANCELADO)) {
					return statusPedidoDAO.findById(StatusPedidoHelper.ID_STATUS_CANCELADO, ca.getStatusPedido()).get();
				}
			}
		}
		return findStatus(listControleAprovacao);
	}

	/**
	 * @param listControleAprovacao
	 * @return the first pending active status
	 */
	private StatusPedido findStatus(List<ControleAprovacao> listControleAprovacao) {
		Stream<ControleAprovacao> stream = listControleAprovacao.stream();
		ControleAprovacao controleAprovacao = stream
				.filter(ca -> ca.isAtivo()
						&& ca.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_PENDENTE))
				.findFirst().orElse(null);
		return controleAprovacao != null ? controleAprovacao.getStatusPedido() : finalStatusAprovacao;
	}

}

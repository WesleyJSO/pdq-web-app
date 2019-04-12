package com.s3.business.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.StatusPedido;
import com.s3.dao.impl.PedidoDAO;
import com.s3.dao.impl.StatusPedidoDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusControleAprovacaoHelper;
import com.s3.helper.StatusPedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 7 de abr de 2019
 *
 */
@Component
public class ChangeStatusPedido implements IStrategy<PedidoHelper> {

	@Autowired
	private PedidoDAO pedidoDAO;

	@Autowired
	private StatusPedidoDAO statusPedidoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.get();
		StatusPedido finalStatus = findFinalStatus(pedido);
		Optional<Stream<ControleAprovacao>> optional = aCase.getResult().getEntities();
		List<ControleAprovacao> listControleAprovacao = optional.get().collect(Collectors.toList());
		aCase.getResult().addEntity("oldStatus", pedido.getStatusPedido());
		StatusPedido newStatus = null;
		newStatus = findStatus(listControleAprovacao, pedido);
		// if there's no more pending approvals, set the given final status
		if (null == newStatus)
			newStatus = finalStatus;
		pedido.setStatusPedido(newStatus);
		pedido.setDtAlteracaoAprovacao(LocalDateTime.now());
		pedidoDAO.save(pedido);
		aCase.getResult().addEntities(listControleAprovacao.stream());
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
			if (ca.isAtivo()
					&& ca.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_REPROVADO)) {
				Long idDisaprove;
				if (pedido.getOrcamento())
					idDisaprove = StatusPedidoHelper.ID_STATUS_NAO_APROVADO;
				else
					idDisaprove = StatusPedidoHelper.ID_STATUS_RECUSADO;
				return statusPedidoDAO.findById(idDisaprove, ca.getStatusPedido()).get();
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
		return controleAprovacao != null ? controleAprovacao.getStatusPedido() : null;
	}

}

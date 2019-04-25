package com.s3.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.StatusPedido;
import com.s3.dao.impl.StatusPedidoDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusPedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 25 de abr de 2019
 *
 */
@Component
public class DisapproveItems implements IStrategy<PedidoHelper> {

	@Autowired
	private StatusPedidoDAO statusPedidoDAO;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optional = aCase.getResult().getEntity();
		Pedido pedido = optional.get();
		
		List<ControleAprovacao> listControleAprovacao = aEntity.getListControleAprovacao();
		StatusPedido newStatus = findStatus(listControleAprovacao, pedido);
		if (null != newStatus)
			pedido.getListPedidoItem().forEach(item -> {
				item.setStatusAprovacao(newStatus);
			});
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
				if (ca.getDisapproved()) {
					Long idDisaprove;
					if (!pedido.getOrcamento())
						idDisaprove = StatusPedidoHelper.ID_STATUS_NAO_APROVADO;
					else
						idDisaprove = StatusPedidoHelper.ID_STATUS_RECUSADO;
					return statusPedidoDAO.findById(idDisaprove, ca.getStatusPedido()).get();
				} else if (ca.getCanceled()) {
					return statusPedidoDAO.findById(StatusPedidoHelper.ID_STATUS_CANCELADO, ca.getStatusPedido()).get();
				}
			}
		}
		return null;
	}
}

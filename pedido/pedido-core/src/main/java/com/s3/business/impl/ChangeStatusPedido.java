package com.s3.business.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.StatusPedido;
import com.s3.dao.impl.PedidoDAO;
import com.s3.helper.PedidoHelper;

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

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.get();
		// save the old status on aCase result
		aCase.getResult().addEntity("changeStatusPedidoResult", pedido.getStatusPedido());
		StatusPedido newStatus = null;
		newStatus = findStatus(pedido);
		pedido.setStatusPedido(newStatus);
		pedido.setDtAlteracaoAprovacao(LocalDateTime.now());
		pedidoDAO.save(pedido);
	}

	private StatusPedido findStatus(Pedido pedido) {
		StatusPedido lowerOrderStatus = null;
		int lowerOrder = Integer.MAX_VALUE;
		for (PedidoItem pedidoItem : pedido.getListPedidoItem()){
			if (pedidoItem.getStatusAprovacao().getOrdem() < lowerOrder){
				lowerOrderStatus = pedidoItem.getStatusAprovacao();
				lowerOrder = lowerOrderStatus.getOrdem();
			}
		}
		return lowerOrderStatus;
	}

}

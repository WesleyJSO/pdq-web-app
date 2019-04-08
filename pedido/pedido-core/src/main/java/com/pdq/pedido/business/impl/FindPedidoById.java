package com.pdq.pedido.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.dao.impl.PedidoDAO;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.helper.PedidoHelper;

@Component
public class FindPedidoById implements IStrategy<PedidoHelper> {

	@Autowired private PedidoDAO pedidoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if (aEntity != null && aEntity.getId() != null) {
			Optional<Pedido> pedido = pedidoDAO.findById(aEntity.getId(), new Pedido());
			if(pedido.isPresent()) {
				aCase.getResult().addEntity(pedido.get());
				return;
			}
		}
	}
}

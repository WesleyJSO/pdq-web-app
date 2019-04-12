package com.s3.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.Pedido;
import com.s3.dao.impl.PedidoDAO;
import com.s3.helper.PedidoHelper;

@Component
public class FindPedidoById implements IStrategy<PedidoHelper> {

	@Autowired
	private PedidoDAO pedidoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if (aEntity != null && aEntity.getId() != null) {
			Optional<Pedido> pedido = pedidoDAO.findById(aEntity.getId(), new Pedido());
			if (pedido.isPresent()) {
				aCase.getResult().addEntity(pedido.get());
				return;
			}
		}
		error(aCase, "Pedido não encontrado", true);
	}

	private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}
}

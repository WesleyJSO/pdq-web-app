package com.pdq.pedido.core.bussiness.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.dao.impl.GenericDAO;
import com.pdq.pedido.domain.Pedido;

@Component
public class FindPedido implements IStrategy<Pedido> {

	@Autowired private GenericDAO<Pedido> dao;

	@Override
	public void process(Pedido aEntity, INavigationCase<Pedido> aCase) {
		Optional<Pedido> order = dao.find(aEntity.getId(), Pedido.class);
		
		if(order.isPresent()) {
			aCase.suspendExecution("Pedido ID: " + aEntity.getId() + " inexistente ou inválido");
			return;
		}
	}
}

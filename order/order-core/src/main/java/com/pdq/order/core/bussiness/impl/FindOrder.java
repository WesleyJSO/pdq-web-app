package com.pdq.order.core.bussiness.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.dao.impl.GenericDAO;
import com.pdq.order.domain.Order;

@Component
public class FindOrder implements IStrategy<Order> {

	@Autowired private GenericDAO<Order> dao;

	@Override
	public void process(Order aEntity, INavigationCase<Order> aCase) {
		Optional<Order> order = dao.find(aEntity.getId(), Order.class);
		
		if(order.isPresent()) {
			aCase.suspendExecution("Pedido ID: " + aEntity.getId() + " inexistente ou inválido");
			return;
		}
	}
}

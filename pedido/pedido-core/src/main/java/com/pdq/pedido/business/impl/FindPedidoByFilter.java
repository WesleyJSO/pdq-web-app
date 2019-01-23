package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.IPedidoDAO;
import com.pdq.pedido.filter.PedidoHelper;

@Component
public class FindPedidoByFilter implements IStrategy<PedidoHelper> {
	
	@Autowired private IPedidoDAO dao;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if(aEntity != null) {
			Filter<PedidoHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.filter(filter));
			return;
		}
		aCase.getResult().setMessage("entidade Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

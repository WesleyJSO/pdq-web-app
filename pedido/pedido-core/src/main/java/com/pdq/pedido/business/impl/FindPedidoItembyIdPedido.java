package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.PedidoItemDAO;
import com.pdq.pedido.domain.PedidoItem;

@Component
public class FindPedidoItembyIdPedido implements IStrategy<PedidoItem> {

	@Autowired private PedidoItemDAO dao;
	
	@Override
	public void process(PedidoItem aEntity, INavigationCase<PedidoItem> aCase) {
		if(aEntity != null && aEntity.getPedido() != null && aEntity.getPedido().getIdPedido() != null) {
			Filter<PedidoItem> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.findByIdPedido(filter));
		}
		
	}

}

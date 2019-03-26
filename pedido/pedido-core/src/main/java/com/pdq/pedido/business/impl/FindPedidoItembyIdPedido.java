package com.pdq.pedido.business.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.PedidoItemDAO;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.PedidoItemHelper;

@Component
public class FindPedidoItembyIdPedido implements IStrategy<PedidoItemHelper> {

	@Autowired private PedidoItemDAO dao;
	
	@Override
	public void process(PedidoItemHelper aEntity, INavigationCase<PedidoItemHelper> aCase) {
		if(aEntity != null && aEntity.getPedido() != null && aEntity.getPedido().getId() != null) {
			Filter<PedidoItemHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			Optional<Stream<PedidoItem>> pedido = dao.findByPedidoItemIdPedido(filter);
			if(pedido.isPresent()) {
				aCase.getResult().addEntities(pedido.get());
			}
		}
		
	}

}

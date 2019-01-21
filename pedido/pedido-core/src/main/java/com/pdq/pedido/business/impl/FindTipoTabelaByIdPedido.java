package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.TipoTabelaDAO;
import com.pdq.pedido.domain.PedidoItem;

@Component
public class FindTipoTabelaByIdPedido implements IStrategy<PedidoItem> {
	
	@Autowired private TipoTabelaDAO dao;
	
	@Override
	public void process(PedidoItem aEntity, INavigationCase<PedidoItem> aCase) {
		if(aEntity != null && aEntity.getPedido() != null && aEntity.getPedido().getIdPedido() != null) {
			Filter<PedidoItem> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.findByIdPedido(filter));
		}
		
	}

}

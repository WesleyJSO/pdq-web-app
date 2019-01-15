package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.CidadeDAO;
import com.pdq.pedido.domain.Cidade;

@Component
public class FindCidadeByIdEstado implements IStrategy<Cidade> {
	
	@Autowired private CidadeDAO dao;
	
	@Override
	public void process(Cidade aEntity, INavigationCase<Cidade> aCase) {
		Filter<Cidade> filter = new Filter<>();
		filter.setEntity(aEntity);
		if(filter.getEntity() != null && filter.getEntity().getEstado() != null) {
			aCase.getResult().addEntities(dao.filter(filter));
		}
	}
}

package com.pdq.aprovacao.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.aprovacao.dao.IDAO;
import com.pdq.aprovacao.domain.Regra;

@Component
public class FindRegraByIdPedido implements IStrategy<Regra> {

	@Autowired IDAO<Regra> dao;
	
	@Override
	public void process(Regra aEntity, INavigationCase<Regra> aCase) {
		if(aEntity != null) {
			Filter<Regra> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.filter(filter));
			return;
		}
	}
}

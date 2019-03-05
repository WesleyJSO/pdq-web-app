package com.pdq.pedido.business.impl;

import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.RegraDAO;
import com.pdq.pedido.helper.RegraHelper;

@Component
public class FindControleAprovacaoByIdPedido implements IStrategy<RegraHelper> {

	@Autowired RegraDAO dao;
	
	@Override
	public void process(RegraHelper aEntity, INavigationCase<RegraHelper> aCase) {
		if(aEntity != null && !Strings.isNullOrEmpty(((RegraHelper)aEntity).getIdPedido())) {
			Filter<RegraHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.findControleAprovacaoByIdPedido(filter));
			return;
		}
		aCase.getResult().setMessage("entidade Regra não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

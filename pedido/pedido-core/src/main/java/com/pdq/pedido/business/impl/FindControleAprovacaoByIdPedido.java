package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.google.common.base.Strings;
import com.pdq.pedido.dao.impl.ControleAprovacaoDAO;
import com.pdq.pedido.helper.ControleAprovacaoHelper;

@Component
public class FindControleAprovacaoByIdPedido implements IStrategy<ControleAprovacaoHelper> {

	@Autowired
	ControleAprovacaoDAO controleAprovacaoDAO;

	@Override
	public void process(ControleAprovacaoHelper aEntity, INavigationCase<ControleAprovacaoHelper> aCase) {
		if (aEntity != null && null != aEntity.getPedido()
				&& !Strings.isNullOrEmpty(((ControleAprovacaoHelper) aEntity).getPedido().getId())) {
			Filter<ControleAprovacaoHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(controleAprovacaoDAO.findControleAprovacaoByIdPedido(filter));
			return;
		}
		aCase.getResult().setMessage("Aprovações não encontradas.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

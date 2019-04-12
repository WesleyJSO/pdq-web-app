package com.s3.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.s3.dao.impl.PedidoDAO;
import com.s3.helper.PedidoHelper;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 06-03-2019 12:50:46
 *
 */
@Component
public class FindPedidoByFilter implements IStrategy<PedidoHelper> {
	
	@Autowired private PedidoDAO dao;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if(aEntity != null) {
			Filter<PedidoHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.filterPedidoHelper(filter));
			return;
		}
		aCase.getResult().setMessage("entidade Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

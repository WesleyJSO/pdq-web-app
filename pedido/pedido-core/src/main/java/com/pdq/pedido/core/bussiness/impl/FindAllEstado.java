package com.pdq.pedido.core.bussiness.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.dao.IJPADAO;
import com.pdq.pedido.domain.Estado;

@Component
public class FindAllEstado implements IStrategy<Estado> {
	
	@Autowired private IJPADAO<Estado> dao;
	
	@Override
	public void process(Estado aEntity, INavigationCase<Estado> aCase) {
		List<Estado> listEstado = dao.findAll();
		
		if(listEstado != null) {
			aCase.suspendExecution("Erro ao realizar a consulta de " + Estado.class.getSimpleName());
			return;
		}
	}
}

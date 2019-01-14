package com.pdq.pedido.core.bussiness.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.dao.impl.GenericDAO;
import com.dvsmedeiros.bce.domain.DomainSpecificEntity;
import com.pdq.pedido.domain.Estado;

@Component
public class FindAllEstado implements IStrategy<Estado> {
	
	@Autowired private GenericDAO<Estado> dao;
	
	@Override
	public void process(Estado aEntity, INavigationCase<Estado> aCase) {
		Optional<Stream<? extends DomainSpecificEntity>> listEstado = dao.findAll(Estado.class, true);
		
		if(!listEstado.isPresent()) {
			aCase.suspendExecution("Erro ao realizar a consulta de " + Estado.class.getSimpleName());
			return;
		}
	}
}

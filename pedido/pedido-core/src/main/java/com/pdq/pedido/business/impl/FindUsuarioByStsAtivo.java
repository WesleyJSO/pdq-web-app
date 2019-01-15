package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.UsuarioDAO;
import com.pdq.pedido.domain.Usuario;

@Component
public class FindUsuarioByStsAtivo implements IStrategy<Usuario> {

	@Autowired private UsuarioDAO dao;
	
	@Override
	public void process(Usuario aEntity, INavigationCase<Usuario> aCase) {
		Filter<Usuario> filter = new Filter<>();
		filter.setEntity(aEntity);
		if(filter.getEntity() != null) {
			aCase.getResult().addEntities(dao.filter(filter));
		}
		
	}

}

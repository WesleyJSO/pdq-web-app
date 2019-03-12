package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.RegionalDAO;
import com.pdq.pedido.dao.impl.UsuarioDAO;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.helper.UsuarioHelper;

@Component
public class FindRegionalByIdUsuario implements IStrategy<UsuarioHelper> {
	
	@Autowired RegionalDAO regionalDAO;
	@Autowired UsuarioDAO usuarioDAO;
	
	@Override
	public void process(UsuarioHelper aEntity, INavigationCase<UsuarioHelper> aCase) {
		
		if(aEntity != null && aEntity.getId() != null) {
			Filter<Usuario> filter = new Filter<>();
			filter.setEntity(usuarioDAO.findById(aEntity));
			aCase.getResult().addEntities(regionalDAO.findByUsuario(filter));
		}
	}
}

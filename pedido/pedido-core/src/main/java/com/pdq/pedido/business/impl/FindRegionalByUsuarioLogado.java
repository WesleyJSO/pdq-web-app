package com.pdq.pedido.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.RegionalDAO;
import com.pdq.pedido.dao.impl.UsuarioDAO;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.helper.RegionalHelper;

@Component
public class FindRegionalByUsuarioLogado implements IStrategy<RegionalHelper> {

	@Autowired private RegionalDAO regionalDAO;
	@Autowired private UsuarioDAO usuarioDAO;
	
	@Override
	public void process(RegionalHelper aEntity, INavigationCase<RegionalHelper> aCase) {
		
		Filter<Usuario> filter = new Filter<>();
		filter.setEntity(usuarioDAO.getLoggedUser());
		aCase.getResult().addEntities(regionalDAO.findByUsuario(filter));	
	}
}

package com.pdq.usuario.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.usuario.domain.Usuario;
import com.pdq.usuario.dao.impl.UsuarioDAO;

@Component
public class FindUsuarioByStsAtivo implements IStrategy<Usuario> {

	@Autowired private UsuarioDAO dao;
	
	@Override
	public void process(Usuario aEntity, INavigationCase<Usuario> aCase) {
		if(aEntity != null) {
			Filter<Usuario> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.filter(filter));
			return;
		}
		aCase.getResult().setMessage("Entidade Usuário não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

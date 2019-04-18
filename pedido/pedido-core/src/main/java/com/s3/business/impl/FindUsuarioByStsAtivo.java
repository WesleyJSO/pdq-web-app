package com.s3.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.UsuarioHelper;

@Component
public class FindUsuarioByStsAtivo implements IStrategy<UsuarioHelper> {

	@Autowired private UsuarioDAO dao;
	
	@Override
	public void process(UsuarioHelper aEntity, INavigationCase<UsuarioHelper> aCase) {
		if(aEntity != null && aEntity.getStsAtivo() != null) {
			Filter<UsuarioHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			aCase.getResult().addEntities(dao.filter(filter));
			return;
		}
		aCase.getResult().setMessage("Entidade Usuário não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

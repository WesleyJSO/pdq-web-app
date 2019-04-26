package com.s3.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.Usuario;
import com.s3.dao.impl.RegionalDAO;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.UsuarioHelper;

@Component
public class FindRegionalByIdUsuario implements IStrategy<UsuarioHelper> {
	
	@Autowired RegionalDAO regionalDAO;
	@Autowired UsuarioDAO usuarioDAO;
	
	@Override
	public void process(UsuarioHelper aEntity, INavigationCase<UsuarioHelper> aCase) {
		
		if(aEntity != null && aEntity.getId() != null) {
			Optional<Usuario> usuario = usuarioDAO.findById(aEntity.getId(), new Usuario());
			if(usuario.isPresent()) 				
				aCase.getResult().addEntity(usuario.get());
		}
	}
}

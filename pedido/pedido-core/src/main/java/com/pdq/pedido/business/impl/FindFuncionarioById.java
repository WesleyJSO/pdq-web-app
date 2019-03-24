package com.pdq.pedido.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.dao.impl.FuncionarioDAO;
import com.pdq.pedido.domain.Funcionario;
import com.pdq.pedido.helper.FuncionarioHelper;

@Component
public class FindFuncionarioById implements IStrategy<FuncionarioHelper> {

	@Autowired private FuncionarioDAO funcionarioDAO;

	@Override
	public void process(FuncionarioHelper aEntity, INavigationCase<FuncionarioHelper> aCase) {
		if (aEntity != null && aEntity.getId() != null) {
			Optional<Funcionario> funcionario = funcionarioDAO.findById(aEntity.getId(), aEntity);
			if(funcionario.isPresent()) {
				aCase.getResult().addEntity(funcionario.get());
				return;
			}
		}
	}
}

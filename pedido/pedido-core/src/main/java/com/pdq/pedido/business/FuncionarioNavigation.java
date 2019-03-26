package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.FindFuncionarioById;
import com.pdq.pedido.helper.FuncionarioHelper;

@Configuration
public class FuncionarioNavigation {

	@Autowired private FindFuncionarioById findFuncionarioById;
	
	@Bean(name = "FIND_FUNCIONARIO_BY_ID")
	public Navigation<FuncionarioHelper> findFuncionarioById() {
		return new NavigationBuilder<FuncionarioHelper>()
				.next(findFuncionarioById)
				.build();
	}
}

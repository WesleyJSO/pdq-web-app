package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.FindCidadeByIdEstado;
import com.pdq.pedido.domain.Cidade;

@Configuration
public class CidadeNavigation {

	@Autowired private FindCidadeByIdEstado findCidadeByIdEstado;
	
	@Bean(name = "FIND_CIDADE_BY_ID_ESTADO")
	public Navigation<Cidade> findCidadeByIdEstado() {
		
		return new NavigationBuilder<Cidade>()
				.next(findCidadeByIdEstado)
				.build();
	}
}

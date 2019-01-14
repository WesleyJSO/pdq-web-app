package com.pdq.pedido.core.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.core.bussiness.impl.FindAllEstado;
import com.pdq.pedido.domain.Estado;

@Configuration
public class EstadoNavigation {

	@Autowired private FindAllEstado findAllEstado;
	
	@Bean(name = "FIND_ALL_ESTADO")
	public Navigation<Estado> findAllEstado() {
		return new NavigationBuilder<Estado>()
				.next(findAllEstado)
				.build();
	}
}

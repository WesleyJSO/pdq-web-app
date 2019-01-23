package com.pdq.aprovacao.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.aprovacao.business.impl.FindRegraByIdPedido;
import com.pdq.aprovacao.domain.Regra;

@Configuration
public class RegraNavigation {
	
	@Autowired private FindRegraByIdPedido findRegraByIdPedido;
	
	@Bean(name = "FIND_REGRA_BY_ID_PEDIDO")
	public Navigation<Regra> findPedidoByFilter() {
		return new NavigationBuilder<Regra>()
				.next(findRegraByIdPedido)
				.build();
	}
}

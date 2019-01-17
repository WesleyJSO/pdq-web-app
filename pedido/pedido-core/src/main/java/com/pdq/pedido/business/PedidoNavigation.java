package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.FindPedidoByFilter;
import com.pdq.pedido.filter.PedidoFilter;

@Configuration
public class PedidoNavigation {

	@Autowired private FindPedidoByFilter findPedidoByFilter;
	
	@Bean(name = "FIND_PEDIDO_BY_FILTER")
	public Navigation<PedidoFilter> findPedidoByFilter() {
		return new NavigationBuilder<PedidoFilter>()
				.next(findPedidoByFilter)
				.build();
	}
}

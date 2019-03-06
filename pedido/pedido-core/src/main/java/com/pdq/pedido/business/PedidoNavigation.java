package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.FilterPedidoByRegionalUsuario;
import com.pdq.pedido.business.impl.FindPedidoByFilter;
import com.pdq.pedido.helper.PedidoHelper;

@Configuration
public class PedidoNavigation {

	@Autowired private FindPedidoByFilter findPedidoByFilter;
	@Autowired private FilterPedidoByRegionalUsuario filterPedidoByRegionalUsuario;
	
	@Bean(name = "FIND_PEDIDO_BY_FILTER")
	public Navigation<PedidoHelper> findPedidoByFilter() {
		return new NavigationBuilder<PedidoHelper>()
				.next(findPedidoByFilter)
				.build();
	}
	
	@Bean(name = "FILTER_PEDIDO_BY_STATUS")
	public Navigation<PedidoHelper> filterPedidoByStatus() {
		return new NavigationBuilder<PedidoHelper>()
				.next(findPedidoByFilter)
				.next(filterPedidoByRegionalUsuario)
				.build();
	}
}

package com.pdq.pedido.core.bussiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.core.bussiness.impl.FindPedido;
import com.pdq.pedido.domain.Pedido;

@Configuration
public class PedidoNavigation {

	@Autowired private FindPedido findPedido;
	
	@Bean(name = "FIND_ALL_PEDIDO")
	public Navigation<Pedido> findAllPedido() {
		return new NavigationBuilder<Pedido>()
				.next(findPedido)
				.build();
	}
}

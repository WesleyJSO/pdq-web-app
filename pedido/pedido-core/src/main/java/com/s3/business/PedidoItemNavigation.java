package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.s3.business.impl.FindPedidoItembyIdPedido;
import com.s3.helper.PedidoItemHelper;

@Configuration
public class PedidoItemNavigation {


	@Autowired private FindPedidoItembyIdPedido findPedidoItembyIdPedido;
	
	@Bean(name = "FIND_PEDIDO_ITEM_BY_ID_PEDIDO")
	public Navigation<PedidoItemHelper> findPedidoByFilter() {
		return new NavigationBuilder<PedidoItemHelper>()
				.next(findPedidoItembyIdPedido)
				.build();
	}
}

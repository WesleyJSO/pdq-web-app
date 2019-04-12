package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.helper.PedidoHelper;
import com.s3.business.impl.EnviarPedidoSap;
import com.s3.business.impl.MontarObjetoPedidoSap;

@Configuration
public class EnviaPedidoSapNavigation {

	@Autowired private MontarObjetoPedidoSap montarObjetoPedidoSap;
	@Autowired private EnviarPedidoSap enviarPedidoSap;
	
	@Bean(name = "ENVIAR_PEDIDO_SAP")
	public Navigation<PedidoHelper> alterarClienteSap() {
		return new NavigationBuilder<PedidoHelper>()
				.next(montarObjetoPedidoSap)
				.next(enviarPedidoSap)
				.build();
	}
}
package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.s3.business.impl.FindTipoTabelaByIdPedido;
import com.s3.helper.PedidoItemHelper;
@Configuration
public class TipoTabelaNavigation {
	
	@Autowired private FindTipoTabelaByIdPedido findTipoTabelaByIdPedido;
	
	@Bean(name = "FIND_TIPO_TABELA_BY_ID_PEDIDO")
	public Navigation<PedidoItemHelper> findTipoTabelaByIdPedido() {
		return new NavigationBuilder<PedidoItemHelper>()
				.next(findTipoTabelaByIdPedido)
				.build();
	}
}

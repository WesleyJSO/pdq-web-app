package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.FindTipoTabelaByIdPedido;
import com.pdq.pedido.domain.PedidoItem;
@Configuration
public class TipoTabelaNavigation {
	
	@Autowired private FindTipoTabelaByIdPedido findTipoTabelaByIdPedido;
	
	@Bean(name = "FIND_TIPO_TABELA_BY_ID_PEDIDO")
	public Navigation<PedidoItem> findTipoTabelaByIdPedido() {
		return new NavigationBuilder<PedidoItem>()
				.next(findTipoTabelaByIdPedido)
				.build();
	}
}

package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.s3.business.impl.FindControleAprovacaoByIdPedido;
import com.s3.helper.RegraHelper;

@Configuration
public class RegraNavigation {
	
	@Autowired private FindControleAprovacaoByIdPedido findControleAprovacaoByIdPedido;
	
	@Bean(name = "FIND_CONTROLE_APROVACAO_BY_ID_PEDIDO")
	public Navigation<RegraHelper> findPedidoByFilter() {
		return new NavigationBuilder<RegraHelper>()
				.next(findControleAprovacaoByIdPedido)
				.build();
	}
}

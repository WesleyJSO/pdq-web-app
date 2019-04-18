package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.ProcessApprovals;
import com.pdq.pedido.helper.ControleAprovacaoHelper;
import com.s3.business.impl.FindControleAprovacaoByIdPedido;

@Configuration
public class ControleAprovacaoNavigation {
	
	@Autowired private FindControleAprovacaoByIdPedido findControleAprovacaoByIdPedido;
	@Autowired private ProcessApprovals processApprovals;
	
	@Bean(name = "FIND_CONTROLE_APROVACAO_BY_ID_PEDIDO")
	public Navigation<ControleAprovacaoHelper> findControleAprovacaoByIdPedido() {
		return new NavigationBuilder<ControleAprovacaoHelper>()
				.next(findControleAprovacaoByIdPedido)
				.next(processApprovals)
				.build();
	}
}

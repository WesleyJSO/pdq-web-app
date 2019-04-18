package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.s3.business.impl.FindControleAprovacaoByIdPedido;
import com.s3.business.impl.ProcessApprovals;
import com.s3.helper.ControleAprovacaoHelper;

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

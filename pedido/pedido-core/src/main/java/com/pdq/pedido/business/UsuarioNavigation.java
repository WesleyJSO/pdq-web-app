package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.FindUsuarioByStsAtivo;
import com.pdq.pedido.helper.UsuarioHelper;

@Configuration
public class UsuarioNavigation {

	@Autowired private FindUsuarioByStsAtivo findUsuarioByStsAtivo;
	

	@Cacheable("findUsuarioByStsAtivo")
	@Bean(name = "FIND_USUARIO_BY_STS_ATIVO")
	public Navigation<UsuarioHelper> findUsuarioByStsAtivo() {
		
		return new NavigationBuilder<UsuarioHelper>()
				.next(findUsuarioByStsAtivo)
				.build();
	}
}

package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.FindUsuarioByStsAtivo;
import com.pdq.pedido.domain.Usuario;

@Configuration
public class UsuarioNavigation {

	@Autowired private FindUsuarioByStsAtivo findUsuarioByStsAtivo;
	
	@Bean(name = "FIND_USUARIO_BY_STS_ATIVO")
	public Navigation<Usuario> findUsuarioByStsAtivo() {
		
		return new NavigationBuilder<Usuario>()
				.next(findUsuarioByStsAtivo)
				.build();
	}
}

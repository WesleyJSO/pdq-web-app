package com.pdq.usuario.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.usuario.domain.Usuario;
import com.pdq.usuario.business.impl.FindUsuarioByStsAtivo;

@Configuration
public class UsuarioNavigation {

	@Autowired private FindUsuarioByStsAtivo findUsuarioByStsAtivo;
	

	@Cacheable("findUsuarioByStsAtivo")
	@Bean(name = "FIND_USUARIO_BY_STS_ATIVO")
	public Navigation<Usuario> findUsuarioByStsAtivo() {
		
		return new NavigationBuilder<Usuario>()
				.next(findUsuarioByStsAtivo)
				.build();
	}
}

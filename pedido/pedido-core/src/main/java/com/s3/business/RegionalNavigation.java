package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.s3.business.impl.FindRegionalByIdUsuario;
import com.s3.business.impl.FindRegionalByUsuarioLogado;
import com.s3.helper.RegionalHelper;
import com.s3.helper.UsuarioHelper;

@Configuration
public class RegionalNavigation {

	@Autowired private FindRegionalByUsuarioLogado findRegionalByUsuarioLogado;
	@Autowired private FindRegionalByIdUsuario findRegionalByIdUsuario;
	
	@Bean(name = "FIND_REGIONAL_BY_USUARIO_LOGADO")
	public Navigation<RegionalHelper> findRegionalByUsuarioLogado() {
		return new NavigationBuilder<RegionalHelper>()
				.next(findRegionalByUsuarioLogado)
				.build();
	}
	
	@Bean(name = "FIND_REGIONAL_BY_ID_USUARIO")
	public Navigation<UsuarioHelper> findRegionalByIdUsuario() {
		return new NavigationBuilder<UsuarioHelper>()
				.next(findRegionalByIdUsuario)
				.build();
	}
}
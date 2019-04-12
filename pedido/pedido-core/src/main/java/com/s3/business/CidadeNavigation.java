package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.s3.business.impl.FindCidadeByIdEstado;
import com.s3.helper.CidadeHelper;

@Configuration
public class CidadeNavigation {

	@Autowired private FindCidadeByIdEstado findCidadeByIdEstado;
	
	@Bean(name = "FIND_CIDADE_BY_ID_ESTADO")
	public Navigation<CidadeHelper> findCidadeByIdEstado() {
		
		return new NavigationBuilder<CidadeHelper>()
				.next(findCidadeByIdEstado)
				.build();
	}
}

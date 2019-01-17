package com.pdq.regional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmedeiros.bce.core.controller.INavigator;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.regional.domain.Estado;

@Controller
@RequestMapping("${server.controller.prefix}estado")
public class EstadoController extends DomainSpecificEntityController<Estado> {
	
	@Autowired
	@Qualifier("navigator")
	private INavigator<Estado> navigator;
	
	public EstadoController() {
		super(Estado.class);
	}
}

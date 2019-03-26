package com.pdq.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmedeiros.bce.core.controller.INavigator;
import com.pdq.pedido.domain.Estado;
import com.pdq.utils.DomainEntityController;

@Controller
@RequestMapping("${server.controller.prefix}estado")
public class EstadoController extends DomainEntityController<Estado, Long> {
	
	@Autowired
	@Qualifier("navigator")
	private INavigator<Estado> navigator;
	
	public EstadoController() {
		super(Estado.class);
	}
}

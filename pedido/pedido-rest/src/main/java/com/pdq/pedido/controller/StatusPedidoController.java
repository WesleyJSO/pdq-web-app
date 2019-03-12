package com.pdq.pedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.pedido.domain.StatusPedido;

@Controller
@RequestMapping("${server.controller.prefix}statuspedido")
public class StatusPedidoController extends DomainSpecificEntityController<StatusPedido> {

	public StatusPedidoController () {
		super(StatusPedido.class);		
	}
}

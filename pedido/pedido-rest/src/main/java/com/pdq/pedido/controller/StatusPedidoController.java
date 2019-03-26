package com.pdq.pedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pdq.pedido.domain.StatusPedido;
import com.pdq.utils.DomainEntityController;

@Controller
@RequestMapping("${server.controller.prefix}statuspedido")
public class StatusPedidoController extends DomainEntityController<StatusPedido, Long> {

	public StatusPedidoController () {
		super(StatusPedido.class);		
	}
}

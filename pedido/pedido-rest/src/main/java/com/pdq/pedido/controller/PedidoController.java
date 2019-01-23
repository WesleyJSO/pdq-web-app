package com.pdq.pedido.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.filter.PedidoHelper;

@Controller
@RequestMapping("${server.controller.prefix}pedido")
public class PedidoController extends DomainSpecificEntityController<Pedido> {
	
	public PedidoController() {
		super(Pedido.class);
	}
	
	@PostMapping(value = "findbyfilter")
	public @ResponseBody ResponseEntity<?> findByFilter(@RequestBody PedidoHelper filter) {

		try {
			BusinessCase<Pedido> aCase = new BusinessCaseBuilder<Pedido>().withName("FIND_PEDIDO_BY_FILTER");
			navigator.run(filter, aCase);
			Optional<Stream<Pedido>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Pedido.class.getSimpleName());
		}

	}
}

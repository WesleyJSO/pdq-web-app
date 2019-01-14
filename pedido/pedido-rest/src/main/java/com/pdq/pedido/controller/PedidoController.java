package com.pdq.pedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.pedido.domain.Pedido;

@Controller
@RequestMapping("${server.controller.prefix}pedido")
public class PedidoController extends DomainSpecificEntityController<Pedido> {

	public PedidoController() {
		super(Pedido.class);
	}
	
	/*@SuppressWarnings("unchecked")
	@GetMapping
	@Override
	public @ResponseBody ResponseEntity<List<Pedido>> getEntities() {
		try {
			Result result = appFacade
					.findAll(Pedido.class, new BusinessCaseBuilder<Pedido>().defaultContext());
			Optional<Stream<Pedido>> ts = result.getEntities();
			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return (ResponseEntity<List<Pedido>>) ResponseMessage
					.serverError("Erro ao consultar " + Pedido.class.getSimpleName());
		}
	}*/
}

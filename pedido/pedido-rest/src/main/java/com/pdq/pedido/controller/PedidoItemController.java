package com.pdq.pedido.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;

@Controller
@RequestMapping("${server.controller.prefix}pedidoitem")
public class PedidoItemController extends DomainSpecificEntityController<PedidoItem> {

	public PedidoItemController() {
		super(PedidoItem.class);
	}

	@GetMapping(value = "findbyidpedido")
	public @ResponseBody ResponseEntity<?> findByIdPedido(@RequestParam(name = "idPedido") String idPedido) {

		try {
			PedidoItem filter = new PedidoItem();
			Pedido p = new Pedido();
			p.setIdPedido(idPedido);
			filter.setPedido(p);
			BusinessCase<PedidoItem> aCase = new BusinessCaseBuilder<PedidoItem>()
					.withName("FIND_PEDIDO_ITEM_BY_ID_PEDIDO");
			
			navigator.run(filter, aCase);
			Optional<Stream<PedidoItem>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + PedidoItem.class.getSimpleName());
		}

	}
}

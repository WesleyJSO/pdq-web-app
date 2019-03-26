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
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.helper.PedidoItemHelper;
import com.pdq.utils.DomainEntityController;

@Controller
@RequestMapping("${server.controller.prefix}pedidoitem")
public class PedidoItemController extends DomainEntityController<PedidoItem, String> {

	public PedidoItemController() {
		super(PedidoItem.class);
	}

	@GetMapping(value = "findbyidpedido")
	public @ResponseBody ResponseEntity<?> findByIdPedido(@RequestParam(name = "id") String id) {

		try {
			BusinessCase<PedidoItemHelper> aCase = new BusinessCaseBuilder<PedidoItemHelper>()
					.withName("FIND_PEDIDO_ITEM_BY_ID_PEDIDO");
			
			PedidoHelper p = new PedidoHelper();
			PedidoItemHelper pi = new PedidoItemHelper();
			p.setId(id);
			pi.setPedido(p);
			applicationFacade.find(pi, aCase);
			Optional<Stream<PedidoItem>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0)
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			else if(aCase.getResult().hasError())
				return ResponseMessage.serverError(aCase.getResult().getMessage());
			else
				return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + PedidoItem.class.getSimpleName());
		}

	}
}

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
import com.pdq.pedido.domain.TipoTabela;
import com.pdq.pedido.helper.PedidoItemHelper;

@Controller
@RequestMapping("${server.controller.prefix}tipotabela")
public class TipoTabelaController extends DomainSpecificEntityController<TipoTabela> {

	public TipoTabelaController() {
		super(TipoTabela.class);
	}
	
	@GetMapping(value = "findbyidpedido")
	public @ResponseBody ResponseEntity<?> findByIdPedido(@RequestParam(name = "id") String id) {
		try {
			PedidoItemHelper filter = new PedidoItemHelper();
			Pedido p = new Pedido();
			p.setId(id);
			filter.setPedido(p);
			BusinessCase<PedidoItemHelper> aCase = new BusinessCaseBuilder<PedidoItemHelper>()
					.withName("FIND_TIPO_TABELA_BY_ID_PEDIDO");
			
			navigator.run(filter, aCase);
			Optional<Stream<TipoTabela>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + TipoTabela.class.getSimpleName());
		}
	}	
}

package com.pdq.regra.controller;

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
import com.pdq.aprovacao.domain.Regra;
import com.pdq.aprovacao.filter.RegraHelper;

@Controller
@RequestMapping("${server.controller.prefix}regra")
public class RegraController extends DomainSpecificEntityController<Regra> {

	public RegraController() {
		super(Regra.class);
	}
	
	@GetMapping(value = "findbyidpedido")
	public @ResponseBody ResponseEntity<?> findByIdPedido(@RequestParam(name = "idPedido") String idPedido) {
		try {
			RegraHelper filter = new RegraHelper();
			filter.setIdPedido(idPedido);
			BusinessCase<Regra> aCase = new BusinessCaseBuilder<Regra>()
					.withName("FIND_REGRA_BY_ID_PEDIDO");
			
			navigator.run(filter, aCase);
			Optional<Stream<Regra>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Regra.class.getSimpleName());
		}
	}	
}

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
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.pdq.utils.DomainEntityController;
import com.s3.helper.ControleAprovacaoHelper;

@Controller
@RequestMapping("${server.controller.prefix}controleaprovacao")
public class ControleAprovacaoController extends DomainEntityController<ControleAprovacao, Long> {

	public ControleAprovacaoController() {
		super(ControleAprovacao.class);
	}
	
	@GetMapping(value = "findbyidpedido")
	public @ResponseBody ResponseEntity<?> findByIdPedido(@RequestParam(name = "idPedido") String idPedido) {
		try {
			ControleAprovacaoHelper filter = new ControleAprovacaoHelper();
			filter.setPedido(new Pedido());
			filter.getPedido().setId(idPedido);
			BusinessCase<ControleAprovacao> aCase = new BusinessCaseBuilder<ControleAprovacao>()
					.withName("FIND_CONTROLE_APROVACAO_BY_ID_PEDIDO");
			
			navigator.run(filter, aCase);
			Optional<Stream<ControleAprovacao>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			else if (aCase.getResult().hasError())
				return ResponseMessage.serverError(aCase.getResult().getMessage());
			return ResponseMessage.serverError("Erro durante processamento.");

		} catch(Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar as aprovações do pedido.");
		}
	}
}

package com.pdq.pedido.controller;

import java.util.Optional;
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
import com.pdq.pedido.domain.Funcionario;
import com.pdq.pedido.helper.FuncionarioHelper;

@Controller
@RequestMapping("${server.controller.prefix}funcionario")
public class FuncionarioController extends DomainSpecificEntityController<Funcionario> {

	public FuncionarioController() {
		super(Funcionario.class);
	}

	@GetMapping(value = "findbyidusuario")
	public @ResponseBody ResponseEntity<?> findByIdUsuario(@RequestParam(name = "id") String id) {

		try {
			FuncionarioHelper filter = new FuncionarioHelper();
			filter.setId(Long.parseLong(id));
			BusinessCase<Funcionario> aCase = new BusinessCaseBuilder<Funcionario>()
					.withName("FIND_FUNCIONARIO_BY_ID");
			
			navigator.run(filter, aCase);
			Optional<Funcionario> ts = aCase.getResult().getEntity();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				
				return ResponseEntity.ok(ts.get()); 
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Funcionario.class.getSimpleName());
		}
	}
}

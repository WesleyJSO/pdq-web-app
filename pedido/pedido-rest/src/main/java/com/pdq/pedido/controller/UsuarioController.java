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
import com.pdq.pedido.domain.Usuario;

@Controller
@RequestMapping("${server.controller.prefix}usuario")
public class UsuarioController extends DomainSpecificEntityController<Usuario> {

	public UsuarioController() {
		super(Usuario.class);
	}
	
	@GetMapping(value = "findbystsativo")
	public @ResponseBody ResponseEntity<?> findByStsAtivo(@RequestParam(name = "stsAtivo") boolean stsAtivo) {

		try {
			Usuario filter = new Usuario();
			filter.setStsAtivo(stsAtivo);
			BusinessCase<Usuario> aCase = new BusinessCaseBuilder<Usuario>().withName("FIND_USUARIO_BY_STS_ATIVO");
			navigator.run(filter, aCase);
			Optional<Stream<Usuario>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Usuario.class.getSimpleName());
		}

	}
}

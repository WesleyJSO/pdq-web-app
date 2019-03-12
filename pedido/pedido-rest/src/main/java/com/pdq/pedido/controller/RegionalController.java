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
import com.pdq.pedido.domain.Regional;
import com.pdq.pedido.domain.Regra;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.helper.RegionalHelper;
import com.pdq.pedido.helper.UsuarioHelper;

@Controller
@RequestMapping("${server.controller.prefix}regional")
public class RegionalController extends DomainSpecificEntityController<Regional> {

	public RegionalController() {
		super(Regional.class);
	}
	
	@GetMapping(value = "findbyusuariologado")
	public @ResponseBody ResponseEntity<?> findByUsuarioLogado() {
		try {
			RegionalHelper filter = new RegionalHelper();
			BusinessCase<Regional> aCase = new BusinessCaseBuilder<Regional>()
					.withName("FIND_REGIONAL_BY_USUARIO_LOGADO");
			
			navigator.run(filter, aCase);
			Optional<Stream<Regional>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch(Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Regional.class.getSimpleName());
		}
	}
	
	@GetMapping(value = "findbyidusuario")
	public @ResponseBody ResponseEntity<?> findByIdUsuario(@RequestParam(name = "idUsuario") Long idUsuario) {
		try {
			UsuarioHelper filter = new UsuarioHelper();
			filter.setId(idUsuario);
			BusinessCase<Usuario> aCase = new BusinessCaseBuilder<Usuario>()
					.withName("FIND_REGIONAL_BY_ID_USUARIO");
			
			navigator.run(filter, aCase);
			Optional<Stream<Regra>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch(Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Regra.class.getSimpleName());
		}
	}
}

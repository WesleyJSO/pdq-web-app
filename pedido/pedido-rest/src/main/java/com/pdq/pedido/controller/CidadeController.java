package com.pdq.pedido.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.INavigator;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.pdq.pedido.domain.Cidade;
import com.pdq.utils.DomainEntityController;
import com.s3.helper.CidadeHelper;

@Controller
@RequestMapping("${server.controller.prefix}cidade")
public class CidadeController extends DomainEntityController<Cidade, Long> {

	@Autowired
	@Qualifier("navigator")
	private INavigator<CidadeHelper> navigator;

	public CidadeController() {
		super(Cidade.class);
	}

	@PostMapping(value = "filtro")
	public @ResponseBody ResponseEntity<?> findEntityByFilter(@RequestBody CidadeHelper filter) {

		try {
			BusinessCase<CidadeHelper> aCase = new BusinessCaseBuilder<CidadeHelper>()
					.withName("FIND_CIDADE_BY_ID_ESTADO");
			
			applicationFacade.find(filter, aCase);
			Optional<Stream<CidadeHelper>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Cidade.class.getSimpleName());
		}

	}
}

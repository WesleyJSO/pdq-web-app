package com.pdq.pedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.INavigator;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.pedido.domain.Estado;

@Controller
@RequestMapping("${server.controller.prefix}estado")
public class EstadoController extends DomainSpecificEntityController<Estado> {
	
	@Autowired
	@Qualifier("navigator")
	private INavigator<Estado> navigator;
	
	public EstadoController() {
		super(Estado.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping
	@Override
	public @ResponseBody ResponseEntity<List<Estado>> getEntities() {
		try {
			BusinessCase<Estado> aCase = new BusinessCaseBuilder<Estado>()
					.withName("FIND_ALL_".concat(Estado.class.getSimpleName().toUpperCase()));
			
			navigator.run(new Estado(), aCase);
			
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return (ResponseEntity<List<Estado>>) ResponseMessage
					.serverError("Erro ao consultar " + Estado.class.getSimpleName());
		}
	}
}

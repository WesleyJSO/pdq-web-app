package com.pdq.utils;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.INavigator;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.domain.IEntity;
import com.dvsmedeiros.bce.domain.Result;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.dvsmedeiros.rest.rest.controller.BaseController;

public abstract class DomainEntityController <T extends IEntity, R extends Object> extends BaseController {

	@Autowired
	@Qualifier("appFacade")
	protected IFacade<T, R> applicationFacade;

	@Autowired
	@Qualifier("navigator")
	protected INavigator<T> navigator;

	protected Class<? extends T> clazz;

	public DomainEntityController(Class<? extends T> clazz) {
		this.clazz = clazz;
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity getEntityById(@PathVariable R id) {
		try {
			BusinessCase<?> aCase = new BusinessCaseBuilder<T>().defaultContext();
			Result result = applicationFacade.findById(id, clazz, aCase);
			Optional<T> ts = result.getEntity();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0)
				return ResponseEntity.ok(ts.get());
			else if(aCase.getResult().hasError())
				return ResponseMessage.serverError(aCase.getResult().getMessage());
			else
				return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + clazz.getSimpleName());
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping
	public @ResponseBody ResponseEntity getEntities() {
		try {
			BusinessCase<?> aCase = new BusinessCaseBuilder<T>().defaultContext();
			Result result = applicationFacade.findAll(clazz, aCase);
			Optional<Stream<T>> ts = result.getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0)
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			else if(aCase.getResult().hasError())
				return ResponseMessage.serverError(aCase.getResult().getMessage());
			else
				return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + clazz.getSimpleName());
		}
	}
}

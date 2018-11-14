package com.pdq.order.controller;

import java.io.IOException;
import java.util.Optional;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.order.domain.Order;

@Controller
@RequestMapping("${server.controller.prefix}order")
public class OrderController extends DomainSpecificEntityController<Order> {

	@Autowired private BusinessCaseBuilder<Order> businessCaseBuilder;
	
	public OrderController() {
		super(Order.class);
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponseEntity<?> createEntity(
			@RequestPart("report") Order report,
			@RequestParam(name = "file", required = false) MultipartFile file) {
		try {
			
			BusinessCase<?> aCase = businessCaseBuilder.withName("COMPILE_REPORT");			
			Optional.ofNullable(file).ifPresent(template -> {
				navigator.run(report, aCase);				
			});						
			ResponseEntity<?> response = super.createEntity(report);						
			if (!aCase.getResult().hasError()) {
				return response;
			}
			return ResponseMessage.serverError(aCase.getResult().getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro interno ao salvar: " + Order.class.getName());
		}
	}
}

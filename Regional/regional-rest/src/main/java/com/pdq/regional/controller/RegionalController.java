package com.pdq.regional.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.regional.domain.Regional;

@Controller
@RequestMapping("${server.controller.prefix}regional")
public class RegionalController extends DomainSpecificEntityController<Regional> {

	public RegionalController() {
		super(Regional.class);
	}
}

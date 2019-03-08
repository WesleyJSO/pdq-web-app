package com.pdq.pedido.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.domain.Result;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.dvsmedeiros.rest.rest.controller.DomainSpecificEntityController;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.helper.PedidoHelper;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 11:44:34
 *
 */
@Controller
@RequestMapping("${server.controller.prefix}pedido")
public class PedidoController extends DomainSpecificEntityController<Pedido> {
	
	final static Logger LOG = LoggerFactory.getLogger( PedidoController.class );
	
	public PedidoController() {
		super(Pedido.class);
	}
	
	@PostMapping(value = "findbyfilter")
	public @ResponseBody ResponseEntity<?> findByFilter(@RequestBody PedidoHelper filter) {

		try {
			BusinessCase<PedidoHelper> aCase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("FILTER_PEDIDO_BY_STATUS");
			
			navigator.run(filter, aCase);
			Optional<Stream<Pedido>> ts = aCase.getResult().getEntities();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0) {
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			}
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Pedido.class.getSimpleName());
		}

	}
	
	/**
	 * @author Bruno Holanda
	 * Muralis Acessoria e Tecnologia Ltda.
	 * @date 7 de mar de 2019
	 *
	 * @param pedido
	 * @return ResponseEntity
	 */
	@PutMapping(value = "computeapprovementlist")
	public @ResponseBody ResponseEntity<?> computeApprovementList(@RequestBody PedidoHelper pedido) {

		try {
			BusinessCase<PedidoHelper> aCase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("COMPUTE_APPROVEMENT_LIST");
			
			navigator.run(pedido, aCase);
			Optional<Stream<Pedido>> ts = aCase.getResult().getEntities();
			
			Result result = aCase.getResult();

			if (result.hasError()) {
				return ResponseMessage.serverError(result.getMessage());
			}
			return ResponseEntity.ok(ts.get().findFirst().get());

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return ResponseMessage.serverError("Erro ao computar lista de aprovações");
		}

	}
}

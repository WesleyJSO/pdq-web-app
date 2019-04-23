package com.pdq.pedido.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.dvsmedeiros.bce.domain.Result;
import com.dvsmedeiros.rest.domain.ResponseMessage;
import com.pdq.pedido.domain.Pedido;
import com.pdq.utils.DomainEntityController;
import com.s3.helper.PedidoHelper;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 11:44:34
 *
 */
@Controller
@RequestMapping("${server.controller.prefix}pedido")
public class PedidoController extends DomainEntityController<Pedido, String> {
	
	final static Logger LOG = LoggerFactory.getLogger( PedidoController.class );
	
	public PedidoController() {
		super(Pedido.class);
	}
	
	@GetMapping(value = "findbycodsap")
	public @ResponseBody ResponseEntity<?> findByCodSap(@RequestParam(name = "codSap") String codSap) {

		try {
			BusinessCase<PedidoHelper> aCase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("FILTER_BY_COD_SAP");
			
			PedidoHelper p = new PedidoHelper();
			p.setCodSap(codSap);
			
			applicationFacade.find(p, aCase);
			Optional<Pedido> ts = aCase.getResult().getEntity();

			if (ts.isPresent() && Stream.of(ts.get()).count() > 0)
				return ResponseEntity.ok(ts.get());
			else if(aCase.getResult().hasError())
				return ResponseMessage.serverError(aCase.getResult().getMessage());
			return ResponseMessage.serverError("Erro durante processamento da entidade.");
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Pedido.class.getSimpleName());
		}

	}
	
	@PostMapping(value = "findbyfilter")
	public @ResponseBody ResponseEntity<?> findByFilter(@RequestBody PedidoHelper filter) {

		try {
			BusinessCase<PedidoHelper> aCase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("FILTER_PEDIDO_BY_STATUS");
			
			applicationFacade.find(filter, aCase);
			Optional<Stream<Pedido>> ts = aCase.getResult().getEntities();
			
			if (ts.isPresent() && Stream.of(ts.get()).count() > 0)
				return ResponseEntity.ok(ts.get().collect(Collectors.toList()));
			else if (aCase.getResult().hasError())
				return ResponseMessage.serverError(aCase.getResult().getMessage());
			return ResponseMessage.serverError("Erro durante processamento da entidade.");
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.serverError("Erro ao consultar " + Pedido.class.getSimpleName());
		}

	}
	
	/**
	 * @author Bruno Holanda
	 * Muralis Acessoria e Tecnologia Ltda.
	 * @date 7 de mar de 2019
	 */
	@PostMapping(value = "computeapprovementlist")
	public @ResponseBody ResponseEntity<?> computeApprovementList(@RequestBody PedidoHelper pedido) {

		try {
			BusinessCase<PedidoHelper> aCase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("COMPUTE_APPROVEMENT_LIST");
			
			navigator.run(pedido, aCase);
			
			Result result = new Result();

			if (aCase.getResult().hasError())
				result.setError();
			result.setMessage(aCase.getResult().getMessage());
			return ResponseEntity.ok(result);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return ResponseMessage.serverError("Erro ao computar lista de aprovações");
		}

	}
	
	/**
	 * @author Bruno Holanda
	 * Muralis Acessoria e Tecnologia Ltda.
	 * @date 7 de mar de 2019
	 */
	@PutMapping(value = "changestatus")
	public @ResponseBody ResponseEntity<?> changeStatus(@RequestBody PedidoHelper pedido) {

		try {
			BusinessCase<PedidoHelper> aCase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("CHANGE_ORDER_STATUS");
			navigator.run(pedido, aCase);
			
			Optional<Pedido> ts = aCase.getResult().getEntity();
			
			if (ts.isPresent())
				return ResponseEntity.ok(ts.get());
			else if (aCase.getResult().hasError())
				return ResponseMessage.serverError(aCase.getResult().getMessage());
			return ResponseMessage.serverError("Erro durante processamento da entidade.");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return ResponseMessage.serverError("Erro ao alterar o status do pedido");
		}

	}
}

package com.s3.business.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.INavigator;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.s3.helper.PedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 21 de abr de 2019
 *
 */
@Component
public class ProcessPedidoItemStatus implements IStrategy<PedidoHelper> {

	final static Logger LOG = LoggerFactory.getLogger(ProcessPedidoItemStatus.class);
	
	@Autowired
	@Qualifier("navigator")
	protected INavigator<Pedido> navigator;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {

		Optional<Stream<ControleAprovacao>> approvedOptional = aCase.getResult()
				.getEntity("changeStatusControleAprovacaoResult");
		List<ControleAprovacao> listApproved = approvedOptional.isPresent()
				? approvedOptional.get().collect(Collectors.toList()) : Collections.emptyList();
		aCase.getResult().addEntity("changeStatusControleAprovacaoResult", listApproved.stream());

		if (!CollectionUtils.isEmpty(listApproved)) {
			BusinessCase<PedidoHelper> subACase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("APPROVE_ITEMS");
			subACase.setResult(aCase.getResult());
			navigator.run(aEntity, subACase);
			if (subACase.isSuspendExecution())
				aCase.suspendExecution();
		} else {
			BusinessCase<PedidoHelper> subACase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("DISAPPROVE_ITEMS");
			subACase.setResult(aCase.getResult());
			navigator.run(aEntity, subACase);
			if (subACase.isSuspendExecution())
				aCase.suspendExecution();
		}
	}

}

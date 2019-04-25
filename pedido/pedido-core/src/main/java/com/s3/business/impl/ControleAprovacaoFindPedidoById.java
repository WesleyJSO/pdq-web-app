package com.s3.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.INavigator;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder;
import com.google.common.base.Strings;
import com.pdq.pedido.domain.Pedido;
import com.s3.helper.ControleAprovacaoHelper;
import com.s3.helper.PedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 22 de abr de 2019
 *
 */
@Component
public class ControleAprovacaoFindPedidoById implements IStrategy<ControleAprovacaoHelper> {

	@Autowired
	@Qualifier("navigator")
	protected INavigator<Pedido> navigator;
	
	@Override
	public void process(ControleAprovacaoHelper aEntity, INavigationCase<ControleAprovacaoHelper> aCase) {
		if (aEntity != null && null != aEntity.getPedido()
				&& !Strings.isNullOrEmpty(((ControleAprovacaoHelper) aEntity).getPedido().getId())) {
			BusinessCase<PedidoHelper> subACase = new BusinessCaseBuilder<PedidoHelper>()
					.withName("VALIDATE_PEDIDO_PEDITO_ITEM_EXISTENCE");
			PedidoHelper pedidoHelper = new PedidoHelper();
			pedidoHelper.setId(aEntity.getPedido().getId());
			subACase.setResult(aCase.getResult());
			navigator.run(pedidoHelper, subACase);
			if (!aCase.getResult().hasError())
				return;
		}
		error(aCase, "Pedido não encontrado", true);
	}

	private void error(INavigationCase<ControleAprovacaoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}
}

package com.s3.business.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.Pedido;
import com.s3.helper.PedidoHelper;
/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 21 de abr de 2019
 *
 */
@Component
public class CheckPedidoPedidoItem implements IStrategy<PedidoHelper> {

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optional = aCase.getResult().getEntity();
		Pedido pedido = optional.get();
		if (null != pedido) {
			if (CollectionUtils.isEmpty(pedido.getListPedidoItem())){
				error(aCase, "Não foram encontrados itens no pedido.", true);
			}
		} else {
			error(aCase, "Pedido não encontrado", true);
		}
	}

	private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}
}

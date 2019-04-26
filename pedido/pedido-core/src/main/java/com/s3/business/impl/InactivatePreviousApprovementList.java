package com.s3.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.ControleAprovacaoPedidoItem;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.s3.helper.PedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 23 de abr de 2019
 *
 */
@Component
public class InactivatePreviousApprovementList implements IStrategy<PedidoHelper> {
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optional = aCase.getResult().getEntity();
		Pedido pedido = optional.get();
		List<ControleAprovacao> listControle = pedido.getListControleAprovacao();
		if(!CollectionUtils.isEmpty(listControle)) {
			listControle.forEach(controle -> {
				controle.setAtivo(false);
			});
		}
		List<PedidoItem> listPedidoItem = pedido.getListPedidoItem();
		listPedidoItem.forEach(item -> {
			List<ControleAprovacaoPedidoItem> listControleItem = item.getListControleAprovacaoPedidoItem();
			listControleItem.forEach(controle -> {
				controle.setAtivo(false);
			});
		});
	}

}

package com.pdq.pedido.business.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.PedidoItemDAO;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.helper.PedidoItemHelper;

/**
 * @author Bruno Holanda
 * Muralis Acessoria e Tecnologia Ltda.
 * @date 8 de mar de 2019
 *
 */
@Component
public class FillPeditoItemList implements IStrategy<PedidoHelper> {

	@Autowired private PedidoItemDAO dao;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if(aEntity != null) {
			List<PedidoItem> listaPedidoItem = aEntity.getListPedidoItem();
			// Verify null or empty list
			if(CollectionUtils.isEmpty(listaPedidoItem)) {
				Filter<PedidoItemHelper> filter = new Filter<>();
				PedidoItemHelper pih = new PedidoItemHelper();
				pih.setPedido(aEntity);
				filter.setEntity(pih);
				Optional<Stream<PedidoItem>> optionalPedidoItem = dao.findByPedidoItemIdPedido(filter);
				if(optionalPedidoItem.isPresent()) {					
					listaPedidoItem.addAll(optionalPedidoItem.get().collect(Collectors.toList()));
					if(CollectionUtils.isEmpty(listaPedidoItem)){
						aCase.getResult().setMessage("Nenhum item de venda foi encontrado.");
						aCase.getResult().setError();
						aCase.suspendExecution();
						return;
					}
					aEntity.setListPedidoItem(listaPedidoItem);
				}
			}
			return;
		}
		aCase.getResult().setMessage("Entidade Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}

}

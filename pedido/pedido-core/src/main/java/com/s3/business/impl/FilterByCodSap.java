package com.s3.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.Pedido;
import com.s3.dao.impl.PedidoDAO;

@Component
public class FilterByCodSap implements IStrategy<Pedido> {

	@Autowired private PedidoDAO pedidoDAO;
	
	@Override
	public void process(Pedido aEntity, INavigationCase<Pedido> aCase) {
		boolean validCodSap = aEntity != null 
				&& aEntity.getCodSap() != null
				&& aEntity.getCodSap().length() > 6
				&& (aEntity.getCodSap().contains("PN")
						|| aEntity.getCodSap().contains("ON")
						|| aEntity.getCodSap().contains("PF"));
		
		if(validCodSap) {
			Optional<Pedido> pedido = pedidoDAO.findByCodSap(aEntity.getCodSap());
			if(pedido.isPresent())
				aCase.getResult().addEntity(pedido.get());
			else
				error(aCase, "Pedido ".concat(aEntity.getCodSap()).concat(" não encontrado."), true);
			return;				
		}
		error(aCase, "Código SAP inválido.", true);
	}
	
	private void error(INavigationCase<Pedido> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if(suspend)
			aCase.suspendExecution();
	}
}

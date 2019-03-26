package com.pdq.pedido.business.impl;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.impl.RegionalDAO;
import com.pdq.pedido.dao.impl.UsuarioDAO;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.Regional;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.helper.PedidoHelper;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 06-03-2019 12:05:01
 * 
 */
@Component
public class FilterPedidoByRegionalUsuario implements IStrategy<PedidoHelper> {
	
	@Autowired private UsuarioDAO usuarioDAO;
	@Autowired private RegionalDAO regionalDAO;
	
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		
		if(aEntity != null && (aEntity.getRegional() == null || aEntity.getRegional().getId() == null)) {
			
			// verify if orders exists before filter 
			Optional<Stream<Pedido>> streamPedido = aCase.getResult().getEntities();
			if(streamPedido.isPresent() && Stream.of(streamPedido).count() > 0) {
				
				// we have a orders list, find all the regional from user
				Usuario loggedUser =  usuarioDAO.getLoggedUser();
				Filter<Usuario> filter = new Filter<>();
				filter.setEntity(loggedUser);
				
				Stream<Regional> streamRegional = regionalDAO.findByUsuario(filter);
				if(streamRegional != null && Stream.of(streamRegional).count() > 0) {
					
					Supplier<Stream<Pedido>> streamFiltered = () -> streamPedido.get()
							.filter(p -> streamRegional.collect(Collectors.toList()).contains(p.getRegional()));
					
					aCase.getResult().clear();
					aCase.getResult().addEntities(streamFiltered.get());
				}
			}
			return;
		}
		aCase.getResult().setMessage("entidade Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

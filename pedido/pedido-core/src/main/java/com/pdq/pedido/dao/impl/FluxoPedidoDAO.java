package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.FluxoPedido;
import com.pdq.utils.GenericDAO;

/**
 * @author Bruno Holanda
 * Muralis Acessoria e Tecnologia Ltda.
 * @date 8 de mar de 2019
 *
 */

@Repository
@Transactional
public class FluxoPedidoDAO extends GenericDAO<FluxoPedido, Long> {
	
	public Stream<FluxoPedido> findByFluxoPedidoByIdStatusPedidoDe(Filter<? extends FluxoPedido> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& filter.getEntity().getStatusPedidoDe() != null
				&& filter.getEntity().getStatusPedidoDe().getId() != null;
		
		if(validFilter) {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(FluxoPedido.class.getName()).append(" fp ");
			jpql.append(" where fp.statusPedidoDe.id = :id");
			return em.createQuery(jpql.toString(), FluxoPedido.class)
					.setParameter("id", filter.getEntity().getStatusPedidoDe().getId())
					.getResultList().stream();
		}
		return null;
	}

}

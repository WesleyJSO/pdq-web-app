package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.StatusPedidoRegra;
import com.pdq.utils.GenericDAO;

/**
 * @author Bruno Holanda
 * Muralis Acessoria e Tecnologia Ltda.
 * @date 8 de mar de 2019
 *
 */

@Repository
@Transactional
public class StatusPedidoRegraDAO extends GenericDAO<StatusPedidoRegra, Long> {

	public Stream<StatusPedidoRegra> findRegrasByStatusPedido(Filter<? extends StatusPedidoRegra> filter) {
		
		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& filter.getEntity().getStatusPedido() != null
				&& filter.getEntity().getStatusPedido().getId() != null;
		
		if(validFilter) {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(StatusPedidoRegra.class.getName()).append(" spr ");
			jpql.append(" where spr.statusPedido.id = :id");
			return em.createQuery(jpql.toString(), StatusPedidoRegra.class)
					.setParameter("id", filter.getEntity().getStatusPedido().getId())
					.getResultList().stream();
		}
		return null;
	}

}

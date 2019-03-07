package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.utils.GenericDAO;

@Repository
public class PedidoItemDAO extends GenericDAO<PedidoItem, String> {

	
	public Stream<PedidoItem> findByPedidoItemIdPedido(Filter<? extends PedidoItem> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& filter.getEntity().getPedido() != null
				&& filter.getEntity().getPedido().getId() != null;
		
		if(validFilter) {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("select pi from ").append(PedidoItem.class.getName()).append(" pi ");
			jpql.append(" join pi.pedido p");
			jpql.append(" where p.id = :id");
			TypedQuery<PedidoItem> query = em.createQuery(jpql.toString(), PedidoItem.class);
			query.setParameter("id", filter.getEntity().getPedido().getId());
			return query.getResultList().stream();
		}
		return null;
	}

	public Stream<PedidoItem> findByIdPedido(Filter<? extends Pedido> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& filter.getEntity().getId() != null;
		
		if(validFilter) {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("select pi from ").append(PedidoItem.class.getName()).append(" pi ");
			jpql.append(" join pi.pedido p");
			jpql.append(" where p.id = :id");
			TypedQuery<PedidoItem> query = em.createQuery(jpql.toString(), PedidoItem.class);
			query.setParameter("id", filter.getEntity().getId());
			return query.getResultList().stream();
		}
		return null;
	}

}

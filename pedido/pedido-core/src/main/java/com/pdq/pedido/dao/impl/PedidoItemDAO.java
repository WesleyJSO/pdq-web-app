package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.PedidoItemHelper;
import com.pdq.utils.GenericDAO;

@Repository
public class PedidoItemDAO extends GenericDAO<PedidoItem, String> {

	@PersistenceContext
	private EntityManager em;
	
	public Stream<PedidoItem> findPedidoItemByIdPedido(Filter<PedidoItemHelper> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& filter.getEntity().getPedido() != null
				&& filter.getEntity().getPedido().getId() != null;
		
		if(validFilter) {
			
			PedidoItem eFilter = filter.getEntity();
			
			boolean validIdPedido = eFilter.getPedido() != null ? eFilter.getPedido().getId() != null ? true : false : false;
			
			if(validIdPedido) {
				StringBuilder jpql = new StringBuilder();
				jpql.append("select pi from ").append(PedidoItem.class.getName()).append(" pi ");
				jpql.append(" join pi.pedido p");
				jpql.append(" where 1=1");
				jpql.append(" and p.id = :id");
				TypedQuery<PedidoItem> query = em.createQuery(jpql.toString(), PedidoItem.class);
				query.setParameter("id", eFilter.getPedido().getId());
				return query.getResultList().stream();
			}
		}
		return null;
	}
}

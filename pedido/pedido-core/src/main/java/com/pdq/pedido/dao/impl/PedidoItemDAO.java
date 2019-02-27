package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.IPedidoItemDAO;
import com.pdq.pedido.domain.PedidoItem;

@Repository
public class PedidoItemDAO implements IPedidoItemDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Stream<PedidoItem> findByIdPedido(Filter<PedidoItem> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null;
		
		if(validFilter) {
			
			PedidoItem eFilter = filter.getEntity();
			
			boolean validIdPedido = eFilter.getPedido() != null ? eFilter.getPedido().getIdPedido() != null ? true : false : false;
			
			if(validIdPedido) {
				StringBuilder jpql = new StringBuilder();
				jpql.append("select pi from ").append(PedidoItem.class.getName()).append(" pi ");
				jpql.append(" join fetch pi.pedido p ");
				jpql.append(" where 1=1 ");
				jpql.append(" and p.idPedido = :idPedido ");
				TypedQuery<PedidoItem> query = em.createQuery(jpql.toString(), PedidoItem.class);
				query.setParameter("idPedido", eFilter.getPedido().getIdPedido());
				return query.getResultList().stream();
			}
		}
		return null;
	}

}

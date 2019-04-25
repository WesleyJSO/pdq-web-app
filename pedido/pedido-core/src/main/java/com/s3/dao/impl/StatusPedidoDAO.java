package com.s3.dao.impl;

import java.util.stream.Stream;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.StatusPedido;
import com.pdq.utils.GenericDAO;

@Repository
@Transactional
public class StatusPedidoDAO extends GenericDAO<StatusPedido, Long> {
	
	public StatusPedido findById(Long id) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select sp from ").append(StatusPedido.class.getName()).append(" sp ");
		jpql.append(" where sp.id = :id");
		TypedQuery<StatusPedido> query = em.createQuery(jpql.toString(), StatusPedido.class);
		query.setParameter("id", id);
		return query.getResultList().get(0);
	}
	
	public Stream<StatusPedido> findOrdered() {

		StringBuilder jpql = new StringBuilder();
		jpql.append("from ").append(StatusPedido.class.getName()).append(" st ");
		jpql.append(" order by st.ordem");
		return em.createQuery(jpql.toString(), StatusPedido.class)
			.getResultList().stream();
	}
}

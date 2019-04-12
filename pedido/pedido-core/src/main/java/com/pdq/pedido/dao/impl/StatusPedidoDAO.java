package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.StatusPedido;
import com.pdq.utils.GenericDAO;

@Repository
@Transactional
public class StatusPedidoDAO extends GenericDAO<StatusPedido, Long> {
	
	/**
	 * @author Bruno Holanda - Muralis
	 * @date 7 de abr de 2019
	 *
	 * @return ordered status list
	 */
	public Stream<StatusPedido> findOrdered() {

		StringBuilder jpql = new StringBuilder();
		jpql.append("from ").append(StatusPedido.class.getName()).append(" st ");
		jpql.append(" order by st.ordem");
		return em.createQuery(jpql.toString(), StatusPedido.class)
			.getResultList().stream();
	}
}

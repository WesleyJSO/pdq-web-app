package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Cidade;
import com.pdq.pedido.helper.CidadeHelper;
import com.pdq.utils.GenericDAO;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 07-03-2019 10:21:25
 *
 */
@Repository
@Transactional
public class CidadeDAO extends GenericDAO<Cidade, Long> {

	@PersistenceContext
	private EntityManager em;

	public Stream<Cidade> findCidadeByIdEstado(Filter<CidadeHelper> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null
				&& filter.getEntity().getEstado() != null
				&& filter.getEntity().getEstado().getId() != null;

		if (validFilter) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select c from ").append(Cidade.class.getName()).append(" c ");
			jpql.append(" join fetch c.estado e ");
			jpql.append(" where e.id = :id ");
			TypedQuery<Cidade> query = em.createQuery(jpql.toString(), Cidade.class);
			query.setParameter("id", filter.getEntity().getEstado().getId());
			return query.getResultList().stream();
		}
		return null;
	}
}

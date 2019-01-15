package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.ICidadeDAO;
import com.pdq.pedido.domain.Cidade;

@Repository
public class CidadeDAO implements ICidadeDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Stream<Cidade> filter(Filter<Cidade> filter) {
		
		boolean validFilter = filter != null && filter.getEntity() != null;
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select c from ").append(Cidade.class.getName()).append(" c ");
		
		if(validFilter && filter.getEntity().getEstado() != null)
			jpql.append("join fetch c.estado e ");
		
		jpql.append(" where 1=1 ");
		
		if(validFilter && filter.getEntity().getEstado() != null && filter.getEntity().getEstado().getIdEstado() != 0)
			jpql.append(" and e.idEstado = :idEstado ");
		
		TypedQuery<Cidade> query = em.createQuery(jpql.toString(), Cidade.class);
		
		if(validFilter && filter.getEntity().getEstado() != null && filter.getEntity().getEstado().getIdEstado() != 0)
			query.setParameter("idEstado", filter.getEntity().getEstado().getIdEstado());
		
		return query.getResultList().stream();
	}
}

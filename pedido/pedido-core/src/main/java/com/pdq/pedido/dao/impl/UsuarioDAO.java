package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.IUsuarioDAO;
import com.pdq.pedido.domain.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Stream<Usuario> filter(Filter<Usuario> filter) {
		
		// boolean validFilter = filter != null && filter.getEntity() != null;
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select u from ").append(Usuario.class.getName()).append(" u ");
		
		jpql.append(" where 1=1 ");
		jpql.append(" and u.stsAtivo = :stsAtivo ");
		
		// sem filtros por enquanto, ainda não existe necessidade.
		return em.createQuery(jpql.toString(), Usuario.class)
				.setParameter("stsAtivo", true)
				.getResultList()
				.stream()
				.sorted((u1, u2) -> u1.getLogin().compareTo(u2.getLogin()));
	}

}

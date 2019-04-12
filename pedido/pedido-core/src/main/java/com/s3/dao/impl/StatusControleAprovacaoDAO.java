package com.s3.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.StatusControleAprovacao;
import com.pdq.utils.GenericDAO;

@Repository
@Transactional
public class StatusControleAprovacaoDAO extends GenericDAO<StatusControleAprovacao, Long> {
	
	public StatusControleAprovacao findById(Long id) {
			
		StringBuilder jpql = new StringBuilder();
		jpql.append("select pi from ").append(StatusControleAprovacao.class.getName()).append(" pi ");
		jpql.append(" where pi.id = :id");
		TypedQuery<StatusControleAprovacao> query = em.createQuery(jpql.toString(), StatusControleAprovacao.class);
		query.setParameter("id", id);
		return query.getResultList().get(0);
	}

}

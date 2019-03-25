package com.pdq.pedido.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.google.common.base.Strings;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.Regra;
import com.pdq.pedido.helper.RegraHelper;
import com.pdq.utils.GenericDAO;

@Repository
public class RegraDAO extends GenericDAO<Regra, Long> {

	@PersistenceContext
	private EntityManager em;

	public Stream<Regra> findControleAprovacaoByIdPedido(Filter<RegraHelper> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& !Strings.isNullOrEmpty(((RegraHelper)filter.getEntity()).getIdPedido());

		if (validFilter) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select ca from ").append(Pedido.class.getName()).append(" p ")
				.append(" join p.listControleAprovacao ca ")
				.append(" where p.id = :id");
			
			TypedQuery<ControleAprovacao> query = em
					.createQuery(jpql.toString(), ControleAprovacao.class)
					.setParameter("idPedido", ((RegraHelper) filter.getEntity()).getIdPedido());
			
			List<Regra> listRegra = new ArrayList<>();
			query.getResultList()
				.forEach(element -> listRegra.add(element.getRegra()));
			
			return listRegra.stream();
		}
		return null;
	}
	
	public Stream<Regra> findRegraByDescricao(Filter<RegraHelper> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& !Strings.isNullOrEmpty(((RegraHelper)filter.getEntity()).getDescricao());

		if (validFilter) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select r from ").append(Regra.class.getName()).append(" r ")
				.append(" where r.descricao = :descricao");
			
			return em.createQuery(jpql.toString(), Regra.class)
					.setParameter("descricao", filter.getEntity().getDescricao())
					.getResultList().stream();
		}
		return null;
	}
	
	public Stream<Regra> findRegrasByIdStatusPedido(Filter<RegraHelper> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null
				&& filter.getEntity().getIdStatusPedido() != null;

		if (validFilter) {

			StringBuilder jpql = new StringBuilder();
			jpql.append("select r from ").append(Regra.class.getName()).append(" r ")
					.append(" join r.listStatusPedido sp")
					.append(" where sp.id = :id");
			TypedQuery<Regra> query = em
					.createQuery(jpql.toString(), Regra.class)
					.setParameter("id", filter.getEntity().getIdStatusPedido());
			
			List<Regra> listRegra = new ArrayList<>();
			query.getResultList()
				.forEach(element -> listRegra.add(element));
			
			return listRegra.stream();
		}
		return null;
	}
}

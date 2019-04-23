package com.s3.dao.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvsmedeiros.bce.domain.Filter;
import com.google.common.base.Strings;
import com.pdq.pedido.domain.Regra;
import com.pdq.pedido.domain.RegraAprovacaoCor;
import com.pdq.pedido.domain.RegraAprovacaoPrazo;
import com.pdq.pedido.domain.RegraAprovacaoTabela;
import com.pdq.utils.GenericDAO;
import com.s3.helper.RegraAprovacaoPrazoHelper;
import com.s3.helper.RegraHelper;

@Repository
@Transactional
public class RegraDAO extends GenericDAO<Regra, Long> {

	public Regra findRegraById(Filter<? extends Regra> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null
				&& null != (((RegraHelper) filter.getEntity()).getId())
				&& 0l != (((RegraHelper) filter.getEntity()).getId());

		if (validFilter) {
			Regra regra = null;
			StringBuilder jpql = new StringBuilder();
			jpql.append("select r from ").append(RegraAprovacaoCor.class.getName()).append(" r ")
					.append(" where r.id = :id");

			TypedQuery<RegraAprovacaoCor> queryCor = em.createQuery(jpql.toString(), RegraAprovacaoCor.class)
					.setParameter("id", ((RegraHelper) filter.getEntity()).getId());

			try {
				regra = queryCor.getSingleResult();
			} catch (NoResultException e) {
				regra = null;
			}

			if (null == regra) {
				jpql.setLength(0);
				jpql.append("select r from ").append(RegraAprovacaoPrazo.class.getName()).append(" r ")
						.append(" where r.id = :id");

				TypedQuery<RegraAprovacaoPrazo> queryPrazo = em.createQuery(jpql.toString(), RegraAprovacaoPrazo.class)
						.setParameter("id", ((RegraHelper) filter.getEntity()).getId());

				try {
					regra = queryPrazo.getSingleResult();
				} catch (NoResultException e) {
					regra = null;
				}
			}

			if (null == regra) {
				jpql.setLength(0);
				jpql.append("select r from ").append(RegraAprovacaoTabela.class.getName()).append(" r ")
						.append(" where r.id = :id");

				TypedQuery<RegraAprovacaoTabela> queryTabela = em
						.createQuery(jpql.toString(), RegraAprovacaoTabela.class)
						.setParameter("id", ((RegraHelper) filter.getEntity()).getId());

				try {
					regra = queryTabela.getSingleResult();
				} catch (NoResultException e) {
					regra = null;
				}
			}

			if (null == regra) {
				jpql.setLength(0);
				jpql.append("select r from ").append(Regra.class.getName()).append(" r ").append(" where r.id = :id");

				TypedQuery<Regra> queryTabela = em.createQuery(jpql.toString(), Regra.class).setParameter("id",
						((RegraHelper) filter.getEntity()).getId());

				try {
					regra = queryTabela.getSingleResult();
				} catch (NoResultException e) {
					regra = null;
				}
			}

			return regra;
		}
		return null;
	}

	public Stream<Regra> findRegraByDescricao(Filter<? extends Regra> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null
				&& !Strings.isNullOrEmpty(((RegraHelper) filter.getEntity()).getDescricao());

		if (validFilter) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select r from ").append(Regra.class.getName()).append(" r ")
					.append(" where r.descricao = :descricao");

			return em.createQuery(jpql.toString(), Regra.class)
					.setParameter("descricao", filter.getEntity().getDescricao()).getResultList().stream();
		}
		return null;
	}

	public Stream<Regra> findRegrasByIdStatusPedido(Filter<? extends Regra> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null
				&& ((RegraHelper) filter.getEntity()).getIdStatusPedido() != null;

		if (validFilter) {

			StringBuilder jpql = new StringBuilder();
			jpql.append("select r from ").append(Regra.class.getName()).append(" r ")
					.append(" join r.listStatusPedido sp").append(" where sp.id = :id");
			TypedQuery<Regra> query = em.createQuery(jpql.toString(), Regra.class).setParameter("id",
					((RegraHelper) filter.getEntity()).getIdStatusPedido());

			List<Regra> listRegra = new ArrayList<>();
			query.getResultList().forEach(element -> listRegra.add(element));

			return listRegra.stream();
		}
		return null;
	}

	public Stream<RegraAprovacaoPrazo> findAprovacaoPrazoByPedidoItem(Filter<RegraAprovacaoPrazoHelper> filter) {

		RegraAprovacaoPrazoHelper helper = null;
		boolean validFilter = filter != null && filter.getEntity() != null
				&& (helper = (RegraAprovacaoPrazoHelper) filter.getEntity()).getIdLinhaProduto() != null
				&& helper.getIdLinhaProduto() != 0l && helper.getDiasPrazoPagamento() != null;

		if (validFilter) {

			StringBuilder jpql = new StringBuilder();
			jpql.append("select r from ").append(RegraAprovacaoPrazo.class.getName()).append(" r ")
					.append(" join r.lstLinhaProduto lp").append(" where lp.id = :idLinhaProduto")
					.append(" and r.prazoPagamentoInicio <= :diasPrazoPagamento")
					.append(" and r.prazoPagamentoFim >= :diasPrazoPagamento")
					.append(" and r.dataVigenciaInicio <= :today")
					.append(" and r.dataVigenciaFim > :today")
					.append(" and r.ativo = 1");
			TypedQuery<RegraAprovacaoPrazo> query = em.createQuery(jpql.toString(), RegraAprovacaoPrazo.class)
					.setParameter("idLinhaProduto", helper.getIdLinhaProduto())
					.setParameter("diasPrazoPagamento", helper.getDiasPrazoPagamento())
					.setParameter("today", LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("BET"))));

			List<RegraAprovacaoPrazo> listRegra = new ArrayList<>();
			query.getResultList().forEach(element -> listRegra.add(element));

			return listRegra.stream();
		}
		return null;
	}
}

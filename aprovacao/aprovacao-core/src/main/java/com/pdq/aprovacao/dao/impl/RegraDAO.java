package com.pdq.aprovacao.dao.impl;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.aprovacao.dao.IDAO;
import com.pdq.aprovacao.domain.Regra;
import com.pdq.aprovacao.filter.RegraHelper;
import com.pdq.pedido.domain.Pedido;

@Repository
public class RegraDAO implements IDAO<Regra> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Stream<Regra> filter(Filter<Regra> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null;

		if (validFilter) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(filter.getEntity().getClass().getName()).append(" r ");
			RegraHelper aFilter = (RegraHelper) filter.getEntity();
			
			if(aFilter.getIdPedido() != null)
				jpql.append("");
				
			jpql.append(" select p from ").append(Pedido.class.getName()).append(" p ");

			/*if (validCidade || validEstado)
				jpql.append(" left join p.cliente cliente "
						+ " left join cliente.endereco endereco "
						+ " left join endereco.cidade c ");

			if (validEstado)
				jpql.append(" left join c.estado e ");
			if (validRegional)
				jpql.append(" left join fetch p.regional r ");
			if (validUsuarioRtv)
				jpql.append(" left join fetch p.usuarioRtv u ");
			if (validStatusPedido)
				jpql.append(" join fetch p.statusPedido s ");

			jpql.append(" where 1=1 ");

			if (validCodSap)
				jpql.append(" and p.codSap = :codSap");
			if (validCidade)
				jpql.append(" and c.idCidade = :idCidade");
			if (validEstado)
				jpql.append(" and e.idEstado = :idEstado");
			if (validRegional)
				jpql.append(" and r.idRegional = :idRegional");
			if (validUsuarioRtv)
				jpql.append(" and u.idUsuario = :idUsuario");
			if (validStatusPedido)
				jpql.append(" and s.id = :idStatusPedido");
			
			TypedQuery<Pedido> query = em.createQuery(jpql.toString(), Pedido.class);

			if (validCodSap)
				query.setParameter("codSap", eFilter.getCodSap());
			if (validCidade)
				query.setParameter("idCidade", eFilter.getCidade().getIdCidade());
			if (validEstado)
				query.setParameter("idEstado", eFilter.getEstado().getIdEstado());
			if (validRegional)
				query.setParameter("idRegional", eFilter.getRegional().getIdRegional());
			if (validUsuarioRtv)
				query.setParameter("idUsuario", eFilter.getUsuarioRtv().getIdUsuario());
			if (validStatusPedido)
				query.setParameter("idStatusPedido", eFilter.getStatusPedido().getId());

			return query.getResultList().stream();*/
		}
		return null;
	}

}

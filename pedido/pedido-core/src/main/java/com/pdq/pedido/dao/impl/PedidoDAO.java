package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvsmedeiros.bce.domain.Filter;
import com.google.common.base.Strings;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.utils.GenericDAO;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 06-03-2019 13:20:45
 *
 */
@Repository
@Transactional
public class PedidoDAO extends GenericDAO<Pedido, String> {
	
	public Stream<Pedido> filterPedidoHelper(Filter<PedidoHelper> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null;

		if (validFilter) {
			StringBuilder jpql = new StringBuilder();
			PedidoHelper eFilter = filter.getEntity();
			boolean validId = !Strings.isNullOrEmpty(eFilter.getId());
			boolean validCodSap = !Strings.isNullOrEmpty(eFilter.getCodSap());
			boolean validCidade = eFilter.getCidade() != null && eFilter.getCidade().getId() != null;
			boolean validRegional = eFilter.getRegional() != null && eFilter.getRegional().getId() != null;
			boolean validEstado = eFilter.getEstado() != null && eFilter.getEstado().getId() != null;
			boolean validUsuarioRtv = eFilter.getUsuarioRtv() != null && eFilter.getUsuarioRtv().getId() != null;
			boolean validStatusPedido = eFilter.getStatusPedido() != null && eFilter.getStatusPedido().getId() != null;
			jpql.append(" select p from ").append(Pedido.class.getName()).append(" p ");

			if (validCidade || validEstado)
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

			if (validId)
				jpql.append(" and p.id = :idPedido");
			if (validCodSap)
				jpql.append(" and p.codSap = :codSap");
			if (validCidade)
				jpql.append(" and c.id = :idCidade");
			if (validEstado)
				jpql.append(" and e.id = :idEstado");
			if (validRegional)
				jpql.append(" and r.id = :idRegional");
			if (validUsuarioRtv)
				jpql.append(" and u.id = :idUsuarioRtv");
			if (validStatusPedido)
				jpql.append(" and s.id = :idStatusPedido");
			
			TypedQuery<Pedido> query = em.createQuery(jpql.toString(), Pedido.class);

			if (validId)
				query.setParameter("idPedido", eFilter.getId());
			if (validCodSap)
				query.setParameter("codSap", eFilter.getCodSap());
			if (validCidade)
				query.setParameter("idCidade", eFilter.getCidade().getId());
			if (validEstado)
				query.setParameter("idEstado", eFilter.getEstado().getId());
			if (validRegional)
				query.setParameter("idRegional", eFilter.getRegional().getId());
			if (validUsuarioRtv)
				query.setParameter("idUsuarioRtv", eFilter.getUsuarioRtv().getId());
			if (validStatusPedido)
				query.setParameter("idStatusPedido", eFilter.getStatusPedido().getId());

			return query.getResultList().stream();
		}
		return null;
	}
}

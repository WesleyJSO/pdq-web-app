package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.TipoTabela;
import com.pdq.pedido.helper.PedidoItemHelper;
import com.pdq.utils.GenericDAO;

@Repository
public class TipoTabelaDAO extends GenericDAO<TipoTabela, Long> {

	public Stream<TipoTabela> findTipoTabelaByIdPedido(Filter<PedidoItemHelper> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null;
		
		if(validFilter) {

			StringBuilder jpql = new StringBuilder();
			PedidoItem eFilter = filter.getEntity();
			
			boolean validIdPedido = eFilter.getPedido() != null ? eFilter.getPedido().getId() != null ? true : false : false;
			

			if(validIdPedido) {
			
				jpql.append("select tt from ").append(PedidoItem.class.getName()).append(" pi ");
				jpql.append(" join pi.produtoPrecoRegras.tabelaPreco.tipoTabela tt ");
				jpql.append(" and pi.id = :id");
			
				TypedQuery<TipoTabela> query = em.createQuery(jpql.toString(), TipoTabela.class);
				query.setParameter("idPedido", eFilter.getPedido().getId());
				return query.getResultList().stream();
			}
		}
		return null;
	}
}

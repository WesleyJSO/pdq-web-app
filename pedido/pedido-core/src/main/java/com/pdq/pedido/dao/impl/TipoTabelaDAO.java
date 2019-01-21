package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.dao.ITipoTabelaDAO;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.TipoTabela;

@Repository
public class TipoTabelaDAO implements ITipoTabelaDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Stream<TipoTabela> findByIdPedido(Filter<PedidoItem> filter) {

		boolean validFilter = filter != null && filter.getEntity() != null;
		
		if(validFilter) {

			StringBuilder jpql = new StringBuilder();
			PedidoItem eFilter = filter.getEntity();
			
			boolean validIdPedido = eFilter.getPedido() != null ? eFilter.getPedido().getIdPedido() != null ? true : false : false;
			
			jpql.append("select tt from ").append(PedidoItem.class.getName()).append(" pi ");
			
			if(validIdPedido)
				jpql.append(" join pi.pedido p "
						+ " join pi.produtoPrecoRegras ppr "
						+ " join ppr.tabelaPreco tp "
						+ " join tp.tipoTabela tt ");
			
			jpql.append(" where 1=1 ");
			
			if(validIdPedido)
				jpql.append(" and p.idPedido = :idPedido ");
			
			TypedQuery<TipoTabela> query = em.createQuery(jpql.toString(), TipoTabela.class);

			if(validIdPedido)
				query.setParameter("idPedido", eFilter.getPedido().getIdPedido());
			
			return query.getResultList().stream();
		}
		return null;
	}

}

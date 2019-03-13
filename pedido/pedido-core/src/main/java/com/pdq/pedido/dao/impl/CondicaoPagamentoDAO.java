package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.CondicaoPagamento;
import com.pdq.pedido.helper.CondicaoPagamentoHelper;
import com.pdq.utils.GenericDAO;

/**
 * @author Bruno Holanda - Muralis
 * @date 13 de mar de 2019
 *
 */
@Repository
@Transactional
public class CondicaoPagamentoDAO extends GenericDAO<CondicaoPagamento, Long> {

	public Stream<CondicaoPagamento> findByMultipleId(Filter<CondicaoPagamentoHelper> filter){
		
		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& CollectionUtils.isEmpty(filter.getEntity().getIdList());;
		
		if(validFilter) {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(CondicaoPagamento.class.getName()).append(" cP ");
			jpql.append(" where ca.id MEMBER OF :ids");
			return em.createQuery(jpql.toString(), CondicaoPagamento.class)
				.setParameter("ids", filter.getEntity().getIdList())
				.getResultList().stream();
		}
		return null;
	}
}

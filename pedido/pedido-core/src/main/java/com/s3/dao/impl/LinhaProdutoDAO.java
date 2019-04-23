package com.s3.dao.impl;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.pedido.domain.Usuario;
import com.pdq.utils.GenericDAO;
import com.s3.helper.LinhaProdutoHelper;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 07-03-2019 11:35:32
 *
 */
@Repository
@Transactional
public class LinhaProdutoDAO extends GenericDAO<LinhaProduto, Long> {

	public Stream<LinhaProduto> findLinhaProdutoByIdUsuario(Filter<LinhaProdutoHelper> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& filter.getEntity().getIdUsuario() != null
				&& filter.getEntity().getIdUsuario() != 0l;
		
		if(validFilter) {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("select DISTINCT lp from ").append(Usuario.class.getName()).append(" u ");
			jpql.append(" join u.listLinhaProduto lp");
			jpql.append(" where u.id = :id");
			return em.createQuery(jpql.toString(), LinhaProduto.class)
				.setParameter("id", filter.getEntity().getIdUsuario())
				.getResultList().stream();
		}
		return null;
	}

	
}

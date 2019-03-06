package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Regional;
import com.pdq.pedido.domain.RegionalUsuario;
import com.pdq.pedido.domain.Usuario;
import com.pdq.utils.GenericDAO;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 06-03-2019 13:20:42
 *
 */
@Repository
@Transactional
public class RegionalDAO extends GenericDAO<Regional, Long> {

	/**
	 * 
	 * @author José Wesley Silva
	 * 06-03-2019 13:20:54
	 *
	 * @param filter - logged user used to fetch Regional class
	 * @return stream of user regional
	 */
	public Stream<Regional> findByUsuario(Filter<? extends Usuario> filter) {
		
		boolean validUsuario = filter != null && filter.getEntity() != null; 
		
		if(validUsuario) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select distinct(r) from ").append(RegionalUsuario.class.getName()).append(" ru ");
			jpql.append("join ru.regional r ");
			jpql.append("where ru.usuario.id = :idUsuario ");
			
			return em.createQuery(jpql.toString(), Regional.class)
					.setParameter("idUsuario", filter.getEntity().getId())
					.getResultList()
					.stream();
		}
		return null;
	}
}

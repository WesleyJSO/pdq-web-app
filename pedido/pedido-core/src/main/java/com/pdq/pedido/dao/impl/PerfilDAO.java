package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Perfil;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.helper.UsuarioHelper;
import com.pdq.utils.GenericDAO;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 06-03-2019 12:50:50
 *
 */
public class PerfilDAO extends GenericDAO<Perfil, Long> {

	public Stream<Perfil> findByUsuario(Filter<UsuarioHelper> filter) {
		
		boolean validUsuario = filter != null && filter.getEntity() != null;
		
		if(validUsuario) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select p from ").append(Usuario.class.getName()).append("u ");
			jpql.append("fetch join u.listPerfil p ");
			jpql.append("where u.idUsuario = :idUsuario ");
			
			return em.createQuery(jpql.toString(), Perfil.class)
					.setParameter("idUsuario", filter.getEntity().getId())
					.getResultList()
					.stream();
		}
		return null;
	}
}

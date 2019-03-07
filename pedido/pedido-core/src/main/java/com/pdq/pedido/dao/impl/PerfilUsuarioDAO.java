package com.pdq.pedido.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.PerfilUsuario;
import com.pdq.pedido.domain.Usuario;
import com.pdq.utils.GenericDAO;

/**
 * 
 * @author José Wesley Silva Muralis Assessoria e Tecnologia Ltda. 07-03-2019
 *         11:08:29
 *
 */
@Repository
@Transactional
public class PerfilUsuarioDAO extends GenericDAO<PerfilUsuario, String> {

	public Boolean hasProfileByUsuarioAndPerfil(Usuario loggedUser, Long perfil) {
		
		boolean validUserAndPerfil = loggedUser != null 
				&& loggedUser.getId() != null
				&& perfil != null;
		
		if(validUserAndPerfil) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("select count(pu) from ").append(PerfilUsuario.class.getName()).append(" pu ");
			jpql.append("where pu.perfil.id = :idPerfil and pu.usuario.id = :idUsuario");
			
			return em.createQuery(jpql.toString(), Long.class)
						.setParameter("idPerfil", perfil)
						.setParameter("idUsuario", loggedUser.getId())
						.getSingleResult() > 0;
						
		}
		return false;
	}
}

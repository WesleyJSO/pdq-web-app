package com.s3.dao.impl;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.domain.UsuarioLinhaProduto;
import com.pdq.utils.GenericDAO;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 07-03-2019 11:35:32
 *
 */
@Repository
@Transactional
public class UsuarioLinhaProdutoDAO extends GenericDAO<LinhaProduto, Long> {

	public Stream<UsuarioLinhaProduto> findByUsuario(Usuario loggedUser) {

		boolean validUser = loggedUser != null && loggedUser.getId() != null;
		
		if(validUser) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(UsuarioLinhaProduto.class.getName()).append(" ulp ");
			jpql.append(" where ulp.usuario.id = :id");
			return em.createQuery(jpql.toString(), UsuarioLinhaProduto.class)
					.setParameter("id", loggedUser.getId())
					.getResultList()
					.stream();
		}
		return null;
	}
}

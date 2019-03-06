package com.pdq.pedido.dao.impl;

import java.util.stream.Stream;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvsmedeiros.bce.domain.Filter;
import com.google.common.base.Strings;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.helper.UsuarioHelper;
import com.pdq.utils.GenericDAO;

@Repository
@Transactional
public class UsuarioDAO extends GenericDAO<Usuario, Long> {
	
	public Stream<Usuario> filter(Filter<UsuarioHelper> filter) {
		
		boolean validFilter = filter != null && filter.getEntity() != null;
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select u from ").append(Usuario.class.getName()).append(" u ");
		
		jpql.append(" where 1=1 ");
		jpql.append(" and u.stsAtivo = :stsAtivo ");
		
		if(validFilter)
			// sem filtros por enquanto, ainda não existe essa necessidade.
			return em.createQuery(jpql.toString(), Usuario.class)
					.setParameter("stsAtivo", filter.getEntity().isStsAtivo())
					.getResultList()
					.stream()
					.sorted((u1, u2) -> u1.getLogin().compareTo(u2.getLogin()));
		else
			return em.createQuery(jpql.toString(), Usuario.class)
					.setParameter("stsAtivo", true)
					.getResultList()
					.stream()
					.sorted((u1, u2) -> u1.getLogin().compareTo(u2.getLogin()));
	}

	public Usuario findBySenha(String senha) {
		
		boolean validSenha = !Strings.isNullOrEmpty(senha);
		
		if(validSenha) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(Usuario.class.getName()).append(" u ");
			jpql.append(" where senha = :senha");
			
			return em.createQuery(jpql.toString(), Usuario.class)
					.setParameter("senha", senha)
					.getResultList()
					.get(0);
		}
		return null;
	}

	public Usuario findByLogin(String login, boolean fetchPerfil) {
		
		boolean validSenha = !Strings.isNullOrEmpty(login);
		
		if(validSenha) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(Usuario.class.getName()).append(" u ");
			
			if(fetchPerfil)
				jpql.append("left join fetch u.listPerfil p ");

			jpql.append(" where login = :login");
			
			return em.createQuery(jpql.toString(), Usuario.class)
					.setParameter("login", login)
					.getResultList()
					.get(0);
		}
		return null;
	}
	
	public Usuario findByLoginAndSenha(String login, String senha) {
		
		boolean validLoginAndSenha = !Strings.isNullOrEmpty(login) && !Strings.isNullOrEmpty(senha);
		
		if(validLoginAndSenha) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(Usuario.class.getName()).append(" u ");
			jpql.append(" where login = :login and senha = :senha");
			
			return em.createQuery(jpql.toString(), Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getResultList()
					.get(0);
		}
		return null;
	}

	public Usuario getUsuarioLogado() {
		try {
			String login = SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getName();
			return findByLogin(login, false);
		} catch(Exception e) {
			// @FIXME add log system
		}
		return null;
	}
}

package com.s3.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.pdq.pedido.domain.Usuario;
import com.pdq.utils.GenericDAO;
import com.s3.repository.UsuarioRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 07-03-2019 11:08:24
 *
 */
@Repository
@Transactional
public class UsuarioDAO extends GenericDAO<Usuario, Long> {
	
	@Autowired private UsuarioRepository usuarioRepository;

	public Usuario findByLogin(String login, boolean fetchPerfil) {
		
		boolean validSenha = !Strings.isNullOrEmpty(login);
		
		if(validSenha) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(Usuario.class.getName()).append(" u ");
			
			if(fetchPerfil)
				jpql.append("left join fetch u.listPerfil p ");
			
			jpql.append(" where login = :login");
			
			List<Usuario> listUsuario = em.createQuery(jpql.toString(), Usuario.class)
					.setParameter("login", login)
					.getResultList();
			
			if(listUsuario != null && !listUsuario.isEmpty())
				return listUsuario.get(0);
			
		}
		return null;
	}

	public Stream<Usuario> findByStsAtivo(Boolean ativo) {
		Optional<List<Usuario>> listUsuario = Optional.ofNullable(usuarioRepository.findByStsAtivo(ativo));
		return listUsuario.isPresent() 
					? listUsuario.get()
							.stream()
							.sorted((e1, e2) -> e1.getLogin().compareTo(e2.getLogin()))
					: Stream.empty();
	}

	public Optional<Usuario> findBySenha(String senha) {
		return Optional.ofNullable(usuarioRepository.findBySenha(senha));
	}
	
	public Optional<Usuario> findByLoginAndSenha(String login, String senha) {
		return Optional.ofNullable(usuarioRepository.findByLoginAndSenha(login, senha));
	}

	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario getLoggedUser() {
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

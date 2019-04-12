package com.pdq.server.security;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.IEntity;
import com.pdq.pedido.dao.impl.UsuarioDAO;
import com.pdq.pedido.domain.Usuario;

@Component
public class SecurityService implements UserDetailsService {
	
	@Autowired private UsuarioDAO usuarioDAO;
	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// Retrieve logged user
	public static IEntity getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		IEntity entity = null;
		if (authentication.isAuthenticated()) {
			entity = (IEntity) authentication.getPrincipal();
		}
		return entity;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.info("Trying to authenticate " + username);
		Usuario user = usuarioDAO.findByLogin(username, true);
		if (null == user)
			throw new UsernameNotFoundException("Usuário inválido.");
		else
			user.setDtUltimoLogin(LocalDateTime.now());
			/**
			 * remove the line below when all the user has logged in the 
			 * system and have their password changed based on USUARIO.DT_ULTIMO_LOGIN field.
			 * initial date: 04/03/2019
			 */
			// user.setSenha(encodeUserPassword(presentedPassword));
			
			usuarioDAO.save(user);
		return user;
	}

	public static String encodeUserPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public static boolean checkMatchPassword(String oldPassword, String storedPassword) {
		return passwordEncoder.matches(oldPassword, storedPassword);
	}
}
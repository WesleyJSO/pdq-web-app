package com.pdq.server.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdq.pedido.domain.Usuario;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		if (!"POST".equals(request.getMethod()))
			return null;

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		Usuario credentials = null;
		try {
			credentials = objectMapper.readValue(request.getInputStream(), Usuario.class);
			request.getSession().setAttribute("login", credentials.getLogin());
			request.getSession().setAttribute("password", credentials.getSenha());
		} catch(Exception e) {
			e.printStackTrace();
			Object login = request.getSession().getAttribute("login");
			Object password = request.getSession().getAttribute("password");
			if(login != null && password != null) {
				credentials = new Usuario();
				credentials.setLogin(login.toString());
				credentials.setSenha(password.toString());
			}
		}		
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						credentials.getLogin(),
						credentials.getSenha(),
						credentials.getListPerfil()
					)
				);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String json = new ObjectMapper().writeValueAsString(authResult.getPrincipal());
		response.setContentType("application/json");
		response.getWriter().write(json);
		
		new TokenAuthenticationService().addAuthentication(response, authResult.getName());
	}

}

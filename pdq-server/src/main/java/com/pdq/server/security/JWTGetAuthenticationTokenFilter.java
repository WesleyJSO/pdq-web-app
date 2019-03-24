package com.pdq.server.security;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTGetAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	private TokenAuthenticationService authService;
	
	public JWTGetAuthenticationTokenFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        authService = (TokenAuthenticationService) webApplicationContext.getBean("tokenAuthenticationService");
		
		Authentication authentication = authService.getAuthentication((HttpServletRequest) request);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		if(authentication != null) {
			String json = new ObjectMapper().writeValueAsString(authentication.getPrincipal());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		// to stop the filter chain, return the user data
		return null;
	}	
}

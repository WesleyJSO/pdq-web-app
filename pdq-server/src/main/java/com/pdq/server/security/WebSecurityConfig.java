package com.pdq.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Value("${server.controller.prefix}")
	private String prefix;
	
	@Autowired private SecurityService user;
	private static PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
	// private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.addFilterBefore(new CorsFilter(), SessionManagementFilter.class)
		.headers().frameOptions().disable()
		.and()
		.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/static/**").permitAll()
		.antMatchers(HttpMethod.POST, "/api/login").anonymous()
		.antMatchers(HttpMethod.POST, "/h2/**").permitAll()
		.antMatchers(HttpMethod.GET, "/h2/**").permitAll()
		.anyRequest().authenticated()
		.and()
		
		// filter login requests
		.addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		
		// filtra outras requisições para verificar a presença do JWT no header
		.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(user).passwordEncoder(passwordEncoder);
	}
}

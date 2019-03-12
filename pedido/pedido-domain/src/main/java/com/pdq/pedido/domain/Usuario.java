package com.pdq.pedido.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 12-03-2019 11:47:11
 * Persistent class for Usuario table, 
 * is adapted to use spring security
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario extends DomainEntity<Long> implements UserDetails {
	
	private static final long serialVersionUID = 9046719009131757279L;
	
	private String login;
	private String senha;
	private Boolean stsAtivo;
	private LocalDateTime dtUltimoLogin;

	// spring security attributes, getters return stsAtivo value
	@Transient private boolean accountNonExpired;
	@Transient private boolean accountNonLocked;
	@Transient private boolean isCredentialsNonExpired;
							   
	/*@MapsId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Funcionario funcionario;	*/

	@ManyToMany
	@JoinTable(name = "PERFIL_USUARIO", 
		joinColumns = { @JoinColumn(name = "ID_USUARIO") }, 
		inverseJoinColumns = { @JoinColumn(name = "ID_PERFIL") })
	private List<Perfil> listPerfil;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getListPerfil();
	}
	
	public void setAuthorities(List<Perfil> authorities) {
		setListPerfil(authorities);
	}
	
	@Override
	public String getPassword() {
		return getSenha();
	}
	
	// Expected an encoded password 
	public void setPassword(String password) {
		setSenha(password);
	}

	public void setEnabled(boolean enabled) {
		setStsAtivo(enabled);
	}	

	@Override
	public String getUsername() {
		return getLogin();
	}

	@Override
	public boolean isEnabled() {
		return getStsAtivo();
	}

	@Override
	public boolean isAccountNonExpired() {
		return getStsAtivo();
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return getStsAtivo();
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return getStsAtivo();
	}
}

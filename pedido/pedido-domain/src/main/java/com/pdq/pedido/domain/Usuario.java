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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dvsmedeiros.bce.domain.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario extends DomainEntity<Long> implements IEntity, UserDetails {
	
	private static final long serialVersionUID = 9046719009131757279L;
	
	private String login;
	private String senha;
	private boolean stsAtivo;
	private LocalDateTime dtUltimoLogin;

	// spring security attributes, getters return stsAtivo value
	@Transient private boolean accountNonExpired;
	@Transient private boolean accountNonLocked;
	@Transient private boolean isCredentialsNonExpired;
							   
	@MapsId
	@OneToOne
	@JoinColumn(name = "ID_USUARIO")
	private Funcionario funcionario;	

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
		return isStsAtivo();
	}

	@Override
	public boolean isAccountNonExpired() {
		return isStsAtivo();
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return isStsAtivo();
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return isStsAtivo();
	}
}

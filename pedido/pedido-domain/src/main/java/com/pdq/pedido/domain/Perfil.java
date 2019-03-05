package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.dvsmedeiros.bce.domain.IEntity;
import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_PERFIL"))
public class Perfil extends DomainEntity<Long> implements IEntity, GrantedAuthority {
	
	private static final long serialVersionUID = -116633184780027495L;
	
	private String desPerfil;
	private String acronimo;

	@Override
	public String getAuthority() {
		return this.desPerfil;
	}
}

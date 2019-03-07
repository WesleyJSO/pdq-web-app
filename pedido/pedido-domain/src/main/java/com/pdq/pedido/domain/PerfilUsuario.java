package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 07-03-2019 11:05:36
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_PERFIL_USUARIO"))
public class PerfilUsuario extends DomainEntity<String> {

	private static final long serialVersionUID = 5918344613161619130L;

	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
}

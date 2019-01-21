package com.pdq.usuario.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Usuario implements IEntity {
	
	@Id
	private long idUsuario;
	private String login;
	private String senha;
	private boolean stsAtivo;
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "ID_USUARIO")
	private Funcionario funcionario;	
}

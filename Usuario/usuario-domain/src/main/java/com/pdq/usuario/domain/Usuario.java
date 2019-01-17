package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

// classe usuário, vulgo RTV
@Data
@Table
@Entity
public class Usuario implements IEntity {
	
	@Id
	private long idUsuario;
	private String login;
	private String senha;
	private boolean stsAtivo;
}

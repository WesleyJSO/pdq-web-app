package com.pdq.aprovacao.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;
import com.pdq.usuario.domain.Usuario;

import lombok.Data;

@Data
@Entity
@Table
public class ControleAprovacao implements IEntity {
	
	@Id
	private long Id;
	private boolean ativo;
	private LocalDate dataAprovacao;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_STATUS_CONTROLE_APROVACAO")
	private StatusControleAprovacao statusControleAprovacao;

	@ManyToOne
	@JoinColumn(name = "ID_REGRA")
	private Regra regra;
}

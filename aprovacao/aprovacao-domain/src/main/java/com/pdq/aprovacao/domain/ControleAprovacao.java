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

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 27-02-2019 11:17:23
 * 
 * Persist class to control the order approval process, it will define the.
 * @param usuario - user that have approved the order
 * @param statusControleAprovacao - pendente, aprovado, não aprovado.
 * @param regra - approbation rule, can be of type: deadline approval, table approval or color approval
 * 
 */
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

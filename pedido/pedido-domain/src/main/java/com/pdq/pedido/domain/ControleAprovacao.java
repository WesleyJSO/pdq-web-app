package com.pdq.pedido.domain;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * 27-02-2019 11:17:23
 * 
 * Persist class to control the order approval process, it will define the.
 * @param usuario - user that has approved the order
 * @param statusControleAprovacao - pendente, aprovado, não aprovado.
 * @param regra - approbation rule, can be of type: deadline approval, table approval or color approval
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class ControleAprovacao extends DomainEntity<Long> {
	
	private static final long serialVersionUID = -1363589984284663784L;
	
	private boolean ativo;
	private LocalDate dataAprovacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_STATUS_CONTROLE_APROVACAO")
	private StatusControleAprovacao statusControleAprovacao;

	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO")
	private StatusPedido statusPedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PEDIDO")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "ID_REGRA")
	private Regra regra;
}

package com.pdq.pedido.domain;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 13:36:24
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class RegraAprovacaoPrazo extends Regra {

	private static final long serialVersionUID = -8928966767401397813L;
	
	private int numeroDiasInicio;
	private int numeroDiasFim;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private boolean stsAtivo;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
}

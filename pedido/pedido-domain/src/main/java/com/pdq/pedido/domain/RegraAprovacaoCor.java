package com.pdq.pedido.domain;

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
 * 05-03-2019 13:36:04
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class RegraAprovacaoCor extends Regra {

	private static final long serialVersionUID = 4883204970690048206L;
	
	@ManyToOne
	@JoinColumn(name = "ID_COR_PEDIDO")
	private CorPedido corPedido;

	private double percentualInicio;
	private double percentualFim;
}

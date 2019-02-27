package com.pdq.aprovacao.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
public class RegraAprovacaoCor extends Regra {

	@ManyToOne
	@JoinColumn(name = "ID_COR_PEDIDO")
	private CorPedido corPedido;

	private double percentualInicio;
	private double percentualFim;
}

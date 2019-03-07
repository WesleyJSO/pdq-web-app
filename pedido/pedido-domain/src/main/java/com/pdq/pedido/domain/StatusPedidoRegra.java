package com.pdq.pedido.domain;

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
 * 07-03-2019 17:20:51
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_ESTADO"))
public class StatusPedidoRegra extends DomainEntity<Long>{

	private static final long serialVersionUID = 2510016865086167696L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STATUS_PEDIDO")
	private StatusPedido statusPedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REGRA")
	private Regra regra;
}

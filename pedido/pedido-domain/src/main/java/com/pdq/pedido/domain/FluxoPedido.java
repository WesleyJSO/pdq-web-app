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
 * 05-03-2019 13:35:44
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class FluxoPedido extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 2132377504455504638L;
	
	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO_DE")
	private StatusPedido statusPedidoDe;

	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO_PARA")
	private StatusPedido statusPedidoPara;
	
	private String beanValidacao;
}

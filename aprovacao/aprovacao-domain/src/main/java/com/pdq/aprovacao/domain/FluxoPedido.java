package com.pdq.aprovacao.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Entity
@Table
public class FluxoPedido implements IEntity {

	@Id
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO_DE")
	private StatusPedido statusPedidoDe;

	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO_PARA")
	private StatusPedido statusPedidoPara;
}

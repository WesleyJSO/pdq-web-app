package com.pdq.pedido.domain;

import java.time.LocalDate;
import java.time.ZoneId;

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
 * @author Bruno Holanda - Muralis
 * @date 25 de abr de 2019
 *
 * Persist class to control the order items approval process, it will define the.
 * @param usuario - user that has approved the order
 * @param statusPedido - the approved status
 * @param pedidoItem - the related item
 */

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class ControleAprovacaoPedidoItem extends DomainEntity<Long> {

	private static final long serialVersionUID = 4113749727810696884L;

	private boolean ativo;
	private LocalDate dataAprovacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PEDIDO_ITEM")
	private PedidoItem pedidoItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO")
	private StatusPedido statusPedido;

	public ControleAprovacaoPedidoItem(){}
	
	public ControleAprovacaoPedidoItem(PedidoItem pedidoItem, StatusPedido statusPedido, Usuario usuario){
		this.pedidoItem = pedidoItem;
		this.usuario = usuario;
		this.statusPedido = statusPedido;
		ativo = true;
		dataAprovacao = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("BET")));
	}
	
}

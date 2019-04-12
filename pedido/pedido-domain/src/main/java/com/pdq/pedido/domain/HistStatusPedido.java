package com.pdq.pedido.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 7 de abr de 2019
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID"))
@Table(name = "HIST_STATUS_PEDIDO")
public class HistStatusPedido extends DomainEntity<Long> {

	private static final long serialVersionUID = 5532579064038239711L;

	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name = "OBS")
	private String obs;
	
	@OneToOne
	@JoinColumn(name = "ID_PEDIDO")
	private Pedido pedido;

	@OneToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO")
	private StatusPedido statusPedido;
	
	public HistStatusPedido(StatusPedido statusPedido, Usuario usuario, Pedido pedido, String obs){
		this.statusPedido = statusPedido;
		this.usuario = usuario;
		this.pedido = pedido;
		this.obs = obs;
		this.data = new Date();
	}
}
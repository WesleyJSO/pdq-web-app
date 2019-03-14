package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 12:54:58
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class StatusPedido extends DomainEntity<Long> {
	
	private static final long serialVersionUID = -5515558825126212314L;
	
	private String descricaoStatus;
	private int ordem;
	private Boolean aplicaPedido;
	private Boolean aplicaOrcamento;
	
}

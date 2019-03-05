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

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_CIDADE"))
public class Cidade extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 7248909169162582297L;

	@ManyToOne 
	@JoinColumn(name = "ID_ESTADO")
	private Estado estado;
	
	private String nomCidade;
	private String codigoMunicipio;
	private String statusCidade;
}

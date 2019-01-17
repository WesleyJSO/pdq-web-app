package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Cidade implements IEntity {

	@Id	
	private long idCidade;
	
	@ManyToOne 
	@JoinColumn(name = "ID_ESTADO")
	private Estado estado;
	
	private String nomCidade;
	private String codigoMunicipio;
	private String statusCidade;
}

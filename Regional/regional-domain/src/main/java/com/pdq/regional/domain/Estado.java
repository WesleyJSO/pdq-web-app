package com.pdq.regional.domain;

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
public class Estado implements IEntity {

	@Id	
	private long idEstado;
	
	@ManyToOne
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;
	
	private String nomEstado;
	private String sigla;
	
}
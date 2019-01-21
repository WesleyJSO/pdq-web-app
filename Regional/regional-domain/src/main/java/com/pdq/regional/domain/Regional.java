package com.pdq.regional.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Regional implements IEntity {

	@Id
	private long idRegional;
	private String nomRegional;	
	
	@OneToOne
	@JoinColumn(name = "ID_CENTRO_LUCRO")
	private CentroLucro centroLucro;
}

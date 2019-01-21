package com.pdq.regional.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class CentroLucro implements IEntity {

	@Id
	private Long idCentroLucro;
	private String descricao;
	private String codSap;
}

package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Cultura implements IEntity {

	@Id
	private long idCultura;
	private String codCultura;
	private String desCultura;
}

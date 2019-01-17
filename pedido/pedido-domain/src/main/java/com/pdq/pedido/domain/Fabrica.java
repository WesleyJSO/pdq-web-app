package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Fabrica implements IEntity {
	
	@Id
	private long idFabrica;
	private long codFabrica;
	private String desFabrica;
}

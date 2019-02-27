package com.pdq.aprovacao.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class CorPedido implements IEntity {
	
	@Id
	private int id;
	private String nomeCor;
}

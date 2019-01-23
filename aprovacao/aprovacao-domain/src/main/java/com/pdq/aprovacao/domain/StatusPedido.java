package com.pdq.aprovacao.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Entity
@Table
public class StatusPedido implements IEntity {

	@Id
	private long id;
	private int ordem;
	private String descricaoStatus;
}

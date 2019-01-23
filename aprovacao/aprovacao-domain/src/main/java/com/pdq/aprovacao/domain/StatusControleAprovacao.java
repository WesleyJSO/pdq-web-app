package com.pdq.aprovacao.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class StatusControleAprovacao implements IEntity {
	
	@Id
	private long id;
	private String descricao;

}

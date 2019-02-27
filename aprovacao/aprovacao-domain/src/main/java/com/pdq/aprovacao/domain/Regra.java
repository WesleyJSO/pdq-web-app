package com.pdq.aprovacao.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Entity
@Inheritance
public abstract class Regra implements IEntity {
	
	@Id
	private long id;
	private String descricao;
	private boolean ativo;
	private boolean aprovado;
}

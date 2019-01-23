package com.pdq.aprovacao.domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@MappedSuperclass
public class Regra implements IEntity {
	
	@Id
	private long id;
	private String descricao;
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private Perfil perfil;
}

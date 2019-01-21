package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class SetorAtividade implements IEntity {
	
	@Id
	private Long idSetorAtividade;
	private String codSetorAtividade;
	private String desSetorAtividade;

}

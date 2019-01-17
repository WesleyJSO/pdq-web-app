package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class ClassificacaoCliente implements IEntity {

	@Id	
	private Long idClassificacaoCliente;
	private String desClassificacaoCliente;
}
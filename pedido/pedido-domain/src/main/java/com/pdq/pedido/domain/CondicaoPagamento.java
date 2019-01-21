package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class CondicaoPagamento implements IEntity {
	
	@Id
	private long idCondicaoPagamento;
	private String codSap;
	private String condPagamento;
	private int diasPagamento;
	private boolean ativo;
	
}

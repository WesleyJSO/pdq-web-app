package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class TabelaPreco implements IEntity {

	@Id
	private long idTabelaPreco;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_TABELA")
	private TipoTabela TipoTabela;

}

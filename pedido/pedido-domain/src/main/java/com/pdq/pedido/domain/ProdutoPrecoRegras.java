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
public class ProdutoPrecoRegras implements IEntity {

	@Id
	private long idProdutoPreco;
	
	@ManyToOne
	@JoinColumn(name = "ID_TABELA_PRECO")
	private TabelaPreco tabelaPreco;
}

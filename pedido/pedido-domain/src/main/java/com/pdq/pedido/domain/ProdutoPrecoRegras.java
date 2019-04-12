package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_PRODUTO_PRECO"))
public class ProdutoPrecoRegras extends DomainEntity<Long> {

	private static final long serialVersionUID = 6988876037701409548L;

	private String observacaoGpNf;
    private String tipoEmbalagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TABELA_PRECO")
	private TabelaPreco tabelaPreco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "idProduto")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LINHA_PRODUTO")
	private LinhaProduto linhaProduto;
}

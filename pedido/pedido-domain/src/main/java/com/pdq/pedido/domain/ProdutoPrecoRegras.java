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

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 9 de abr de 2019
 *
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_PRODUTO_PRECO"))
public class ProdutoPrecoRegras extends DomainEntity<Long> {

	private static final long serialVersionUID = 6988876037701409548L;

	private String observacaoGpNf;
	private String tipoEmbalagem;
	private String ncm;
	private String unidade;
	private String produtosIguais;
	private String observacaoGp;
	private String barter;
	private String programaCafe;
	private String programaMilho;
	private String programaSoja;
	private Double embalagem;
	private Double densidade;
	private String gerente;
	private Double cargaPerigosa;
	private Double diasParaProducao;
	private Double custoKilo;
	private Double custoGordura;
	private Double custoTotal;
	private Double precoAzul;
	private Double precoVerde;
	private Double precoAmarelo;
	private Double precoVermelho;
	private Double precoPreto;
	private Double comissaoAzul;
	private Double comissaoVerde;
	private Double comissaoAmarelo;
	private Double comissaoVermelho;
	private Double comissaoPreto;
	private Double margemAzul;
	private Double margemVerde;
	private Double margemAmarelo;
	private Double margemVermelho;
	private Double margemPreto;
	private Boolean ativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TABELA_PRECO")
	private TabelaPreco tabelaPreco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LINHA_PRODUTO")
	private LinhaProduto linhaProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UF_ORIGEM_1")
	private Estado ufOrigem1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UF_ORIGEM_2")
	private Estado ufOrigem2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UF_ORIGEM_3")
	private Estado ufOrigem3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UF_ORIGEM_4")
	private Estado ufOrigem4;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ORGANIZACAO")
	private OrganizacaoVenda organizacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FABRICA")
	private Fabrica fabrica;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DEPOSITO")
	private Deposito deposito;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GRUPO_MERCADORIA")
	private GrupoMercadoria grupoMercadoria;
}

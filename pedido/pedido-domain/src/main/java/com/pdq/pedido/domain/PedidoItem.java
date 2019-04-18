package com.pdq.pedido.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity	
@AttributeOverride(name = "id", column = @Column(name = "ID_PEDIDO_ITEM"))
public class PedidoItem extends DomainEntity<String> {
	
	private static final long serialVersionUID = 427916007591827486L;
	
	private Double quantidade;
	private Double valorUnitParaCalculoMargem;
	private Double valorUnitFob;
	private Double valorUnitBruto;
	private Double valorTotal;
	private String tipoFrete;
	private Boolean freteEspecial;
	private Double valorFrete;
	private Double valorFreteUnitario;
	private String tipoAgenciamento;
	private Double agenteFixoPorcent;
	private Double agenteFixoValorPorKilo;
	private Double agenteFixoValorTotal;
	private Double agenteRateioPorcent;
	private Double agenteRateioPorcentSap;
	private Double comissaoRtvPorcent;
	private Double comissaoRtvValor;
	private Double bonusPenalizacao;
	private Double impostos;
	private Double impostosUnitario;
	private Double valorIcmsUnit;
	private Double porcImposto;
	private Double encargosFinanceiros;
	private Double valorJurosUnitario;
	private Double porcJuros;
	private Double volumeTotalKg;
	private String embalagem;
	private String codOrdemSap;
	private String motivoErroSap;
	private String statusOrdemSap;
	private String statusCreditoSap;
	private Double txCambio;
	private Boolean aprovadoGerProduto;
	private Double descontoPorc;
	private LocalDateTime dataFaturamento;
	private LocalDateTime dataPagamento;
	private LocalDateTime dtTxCambio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PEDIDO")
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_UNIDADE")
	private Unidade unidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CULTURA")
	private Cultura cultura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MOEDA")
	private Moeda moeda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FABRICA")
	private Fabrica fabrica;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ORGANIZACAO_VENDAS")
	private OrganizacaoVendas organizacaoVendas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COR")
	private CorPedido corPedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONDICAO_PAGAMENTO")
	private CondicaoPagamento condicaoPagamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_APROVACAO")
	private StatusPedido statusAprovacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO_PRECO_REGRAS")
	private ProdutoPrecoRegras produtoPrecoRegras;

	@ManyToMany
	@JoinTable(name = "CAMPANHA_PEDIDO_ITEM", 
		joinColumns = { @JoinColumn(name = "ID_PEDIDO_ITEM") }, 
		inverseJoinColumns = { @JoinColumn(name = "ID_CAMPANHA") })
	private List<Campanha> listCampanha;
}

package com.pdq.pedido.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pdq.campanha.domain.Campanha;

import lombok.Data;

@Data
@Table
@Entity	
public class PedidoItem implements IEntity {
	
	@Id
	private String idPedidoItem;
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
	private Instant dataFaturamento;
	private LocalDate dataPagamento;
	private LocalDate dtTxCambio;

	@ManyToOne
	@JoinColumn(name = "ID_PEDIDO")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "COD_UNIDADE")
	private Unidade unidade;

	@ManyToOne
	@JoinColumn(name = "ID_CULTURA")
	private Cultura cultura;

	@ManyToOne
	@JoinColumn(name = "ID_MOEDA")
	private Moeda moeda;

	@ManyToOne
	@JoinColumn(name = "ID_FABRICA")
	private Fabrica fabrica;

	@ManyToOne
	@JoinColumn(name = "ID_ORGANIZACAO_VENDAS")
	private OrganizacaoVendas organizacaoVendas;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "ID_COR")
	private CorPedido corPedido;

	@ManyToOne
	@JoinColumn(name = "ID_CONDICAO_PAGAMENTO")
	private CondicaoPagamento condicaoPagamento;

	@ManyToOne
	@JoinColumn(name = "STATUS_APROVACAO")
	private StatusPedido statusAprovacao;

	@OneToOne
	@JoinColumn(name = "ID_PRODUTO_PRECO_REGRAS")
	private ProdutoPrecoRegras produtoPrecoRegras;

	@ManyToMany
	@JoinTable(name = "CAMPANHA_PEDIDO_ITEM", 
		joinColumns = { @JoinColumn(name = "ID_PEDIDO_ITEM") }, 
		inverseJoinColumns = { @JoinColumn(name = "ID_CAMPANHA") })
	private List<Campanha> listCampanha;
}

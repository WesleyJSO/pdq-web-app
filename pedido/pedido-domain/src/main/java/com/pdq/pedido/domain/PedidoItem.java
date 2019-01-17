package com.pdq.pedido.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dvsmedeiros.bce.domain.IEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Table
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPedidoItem")
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

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFaturamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtTxCambio;

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
	@JoinColumn(name = "ID_COR")
	private CorPedido corPedido;

	@ManyToOne
	@JoinColumn(name = "STATUS_APROVACAO")
	private StatusPedido statusAprovacao;

	@OneToOne
	@JoinColumn(name = "ID_PRODUTO_PRECO_REGRAS")
	private ProdutoPrecoRegras produtoPrecoRegras;
}

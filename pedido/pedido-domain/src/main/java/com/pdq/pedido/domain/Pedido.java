package com.pdq.pedido.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 11:45:44
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_PEDIDO"))
public class Pedido extends DomainEntity<String> {
	
	private static final long serialVersionUID = -3072217342133443473L;
	
	private Boolean freteDigitado;
	private String observacaoFrete;
	private Boolean orcamento;
	private String codSap;
	private Boolean campanha;
	private Boolean barter;
	private Boolean ar;
	private Boolean mostraVlrItens;
	private String numeroAr;
	private Boolean vendaAgenciada;
	private String descricaoRota;
	private Double valorDescarregarCaminhao;
	private String numeroColeta;
	private String observacao;
	private String numPedidoCli;
	private LocalDateTime dtCreditoRural;
	private LocalDateTime dtCriacaoPedido;
	
	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO")
	private StatusPedido statusPedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REGIONAL")
	private Regional regional;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO_RTV")
	private Usuario usuarioRtv;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE_COBRANCA")
	private Cliente clienteCobranca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE_ENTREGA")
	private Cliente clienteEntrega;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VENDEDOR_AGENCIADO")
	private VendedorSap vendedorAgenciado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_VENDA")
	private TipoVenda tipoVenda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TRANSPORTADORA")
	private Transportadora transportadora;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RESPONSAVEL_COMISSAO")	
	private Usuario usuarioResponsavelComissao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SETOR_ATIVIDADE")
	private SetorAtividade setorAtividade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO_ORIGEM")
	private Estado estadoOrigem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLASSIFICACAO_CLIENTE")
	private ClassificacaoCliente classificacaoCliente;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<PedidoItem> listPedidoItem;
	
	@Column(name = "DT_ALTER_APROVACAO")
	private LocalDateTime dtAlteracaoAprovacao;

	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<ControleAprovacao> listControleAprovacao;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CAMPANHA_PEDIDO", joinColumns = { @JoinColumn(name = "ID_PEDIDO") }, inverseJoinColumns = { @JoinColumn(name = "ID_CAMPANHA")} )
	private List<Campanha> lstCampanhas;
}
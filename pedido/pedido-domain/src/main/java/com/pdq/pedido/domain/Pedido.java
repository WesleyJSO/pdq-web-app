package com.pdq.pedido.domain;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pdq.regional.domain.Estado;
import com.pdq.regional.domain.Regional;
import com.pdq.usuario.domain.Usuario;

import lombok.Data;

@Data
@Table
@Entity
public class Pedido implements IEntity {
	
	@Id
	private String idPedido;
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
	private Instant dtCreditoRural;
	private Instant dtCriacaoPedido;

	@ManyToMany
	
	@ManyToOne
	@JoinColumn(name = "ID_STATUS_PEDIDO")
	private StatusPedido statusPedido;

	@ManyToOne
	@JoinColumn(name = "ID_REGIONAL")
	private Regional regional;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_RTV")
	private Usuario usuarioRtv;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_VENDA")
	private TipoVenda tipoVenda;

	@ManyToOne
	@JoinColumn(name = "ID_SETOR_ATIVIDADE")
	private SetorAtividade setorAtividade;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO_ORIGEM")
	private Estado estadoOrigem;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLASSIFICACAO_CLIENTE")
	private ClassificacaoCliente classificacaoCliente;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pedido")
	private List<PedidoItem> listPedidoItem;
}
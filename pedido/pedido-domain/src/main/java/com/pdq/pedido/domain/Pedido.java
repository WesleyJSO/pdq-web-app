package com.pdq.pedido.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;


@Data
@Table
@Entity
public class Pedido implements IEntity {

	@Id	private String idPedido;
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

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtSincronismo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreditoRural;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCriacaoPedido;
}
package com.pdq.pedido.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dvsmedeiros.bce.domain.DomainSpecificEntity;


/*@Data
@EqualsAndHashCode(callSuper=false)*/
@Entity
@Table
public class Pedido extends DomainSpecificEntity { 
	
	public Boolean getFreteDigitado() {
		return freteDigitado;
	}

	public void setFreteDigitado(Boolean freteDigitado) {
		this.freteDigitado = freteDigitado;
	}

	public String getObservacaoFrete() {
		return observacaoFrete;
	}

	public void setObservacaoFrete(String observacaoFrete) {
		this.observacaoFrete = observacaoFrete;
	}

	public Boolean getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Boolean orcamento) {
		this.orcamento = orcamento;
	}

	public String getCodSap() {
		return codSap;
	}

	public void setCodSap(String codSap) {
		this.codSap = codSap;
	}

	public Boolean getCampanha() {
		return campanha;
	}

	public void setCampanha(Boolean campanha) {
		this.campanha = campanha;
	}

	public Boolean getBarter() {
		return barter;
	}

	public void setBarter(Boolean barter) {
		this.barter = barter;
	}

	public Boolean getAr() {
		return ar;
	}

	public void setAr(Boolean ar) {
		this.ar = ar;
	}

	public Boolean getMostraVlrItens() {
		return mostraVlrItens;
	}

	public void setMostraVlrItens(Boolean mostraVlrItens) {
		this.mostraVlrItens = mostraVlrItens;
	}

	public String getNumeroAr() {
		return numeroAr;
	}

	public void setNumeroAr(String numeroAr) {
		this.numeroAr = numeroAr;
	}

	public Boolean getVendaAgenciada() {
		return vendaAgenciada;
	}

	public void setVendaAgenciada(Boolean vendaAgenciada) {
		this.vendaAgenciada = vendaAgenciada;
	}

	public String getDescricaoRota() {
		return descricaoRota;
	}

	public void setDescricaoRota(String descricaoRota) {
		this.descricaoRota = descricaoRota;
	}

	public Double getValorDescarregarCaminhao() {
		return valorDescarregarCaminhao;
	}

	public void setValorDescarregarCaminhao(Double valorDescarregarCaminhao) {
		this.valorDescarregarCaminhao = valorDescarregarCaminhao;
	}

	public String getNumeroColeta() {
		return numeroColeta;
	}

	public void setNumeroColeta(String numeroColeta) {
		this.numeroColeta = numeroColeta;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNumPedidoCli() {
		return numPedidoCli;
	}

	public void setNumPedidoCli(String numPedidoCli) {
		this.numPedidoCli = numPedidoCli;
	}

	public Date getDtSincronismo() {
		return dtSincronismo;
	}

	public void setDtSincronismo(Date dtSincronismo) {
		this.dtSincronismo = dtSincronismo;
	}

	public Date getDtCreditoRural() {
		return dtCreditoRural;
	}

	public void setDtCreditoRural(Date dtCreditoRural) {
		this.dtCreditoRural = dtCreditoRural;
	}

	public Date getDtCriacaoPedido() {
		return dtCriacaoPedido;
	}

	public void setDtCriacaoPedido(Date dtCriacaoPedido) {
		this.dtCriacaoPedido = dtCriacaoPedido;
	}

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
	
	public boolean isNumberEven(Integer number) {
	    return number % 2 == 0;
	}
}

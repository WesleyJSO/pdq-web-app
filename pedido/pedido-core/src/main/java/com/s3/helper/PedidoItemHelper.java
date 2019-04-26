package com.s3.helper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.Unidade;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PedidoItemHelper extends PedidoItem { 

	private static final long serialVersionUID = -3048500342714728110L;
	
	public final static String UNIDADE_TONELADA = "TO";
	
	private Pedido pedido;
	private PedidoItem pedidoItem;	
	private String strFreteEspecial;
	private int posicaoGrid;
	private String tonalidade;	
	private Unidade unidade;		
	private boolean considerarValorFobNetPreenchido;
	private boolean considerarComissaoRtvPorcentPreenchido;
	private boolean considerarValorTotalDigitadoPreenchido;
	
	private Double precoUnitVista = 0d;
	private Double margemBrutaValorVista = 0d;
	private Double margemBrutaValorPrazo = 0d;
	private Double custo = 0d;
	private Double lucro = 0d;
	private Double lucroTotal = 0d;
	private Double faturamentoTotal = 0d;	
	private Double mesesPagamentoAposFaturamento = null;
	private Double taxaJuros = null;
	private Double totalPorcentImpostos = null;
	private final String UNIDADE_TO = "TO";
	private Double valorUnitBrutoReal;
	private Double precoUnitVistaReal;
	private Double valorJurosUnitarioReal;
	private Double valorFreteUnitarioReal;
	private Double faturamentoTotalReal;
	private Double comissaoRtvValorReal;
	
	//itens para campanha
	private Double descontoMin;
	private Double descontoMax;
	private Double comissaoAzul;
	private Double comissaoVerde;
	private Double comissaoAmarelo;
	private Double comissaoVermelho;
	private Double comissaoPreto;
	private Double taxaJurosCampanha;
	private Double fatorCampanha;
	private boolean alteraComissaoCampanhaDesconto;
	
	public void carregaValoresGrid(Pedido pedido){
		this.precoUnitVista = calculaPrecoUnitVista();
		if (mesesPagamentoAposFaturamento==null){
			this.mesesPagamentoAposFaturamento = calculaMesesPagamentoAposFaturamento(pedido);
		}
		this.margemBrutaValorVista = calculaMargemBrutaValorVista();
		this.margemBrutaValorPrazo = calculaMargemBrutaValorPrazo();
		this.lucro = calculaLucro();
		this.lucroTotal = calculaLucroTotal();
		this.faturamentoTotal = calculaFaturamentoTotal();
		this.taxaJuros = pedidoItem.getPorcJuros();
		if (totalPorcentImpostos==null){
			this.totalPorcentImpostos = pedidoItem.getPorcImposto();
		}
	}
	
	public PedidoItemHelper(){
		tonalidade = "#FFFFFF";
		
//		FacesContext context = FacesContext.getCurrentInstance();
//		pedidoService = (PedidoService) FacesContextUtils.getWebApplicationContext(context ).getBean("pedidoService");		
	}

	/*métodos abaixo são campos calculados para uso na tela de aprovação de pedido*/ 	
	public Double calculaMesesPagamentoAposFaturamento(Pedido pedido){
		
		//Pedido pedido = pedidoService.getById(pedidoItem.getIdPedido()); 
		Double periodo = pedidoItem.getCondicaoPagamento().getDiasPagamento()==null?null:Double.valueOf(pedidoItem.getCondicaoPagamento().getDiasPagamento());
		
		Double diasCriacaoPedidoToPagamento = 0d;
		
		LocalDateTime dIni = pedido.getDtCriacaoPedido();
		LocalDateTime dFim = null;
		if (pedidoItem.getDataPagamento() != null) {
			dFim = pedidoItem.getDataPagamento();
		} else if (pedidoItem.getDataFaturamento() != null) {
			dFim = pedidoItem.getDataFaturamento();
		}
		
		if (dIni!=null && dFim!=null){
			diasCriacaoPedidoToPagamento = (double) ChronoUnit.DAYS.between(dIni, dFim);
			diasCriacaoPedidoToPagamento += periodo;
		}
		return (diasCriacaoPedidoToPagamento/30d);
		
	}
	
	public Double calculaPrecoUnitVista(){
		Double valorBruto = pedidoItem.getValorUnitBruto();
		Double valorFrete = pedidoItem.getValorFreteUnitario();
		Double valorJuros = pedidoItem.getValorJurosUnitario();
		Double valorImposto = pedidoItem.getImpostosUnitario();		
		return  formataDoubleDuasCasasDecimais(valorBruto - valorFrete - valorJuros - valorImposto); 
	}
	
	public Double calculaMargemBrutaValorVista(){
		Double valorAVista = precoUnitVista;
		Double custo = getCusto(); //pedidoItem.getProdutoPrecoRegras().getCustoKilo();
		
		if (pedidoItem.getTxCambio() != null) {
			valorAVista = valorAVista * pedidoItem.getTxCambio();
		}
		
		//custo sempre está em KG, aq verifica se a unidade é TO para multiplicar o custo se necessário
		if (pedidoItem.getUnidade().getSiglaUnidade().equals(UNIDADE_TO)){
			custo = custo * 1000;			
		}		
		Double margemBrutaValorVista = (valorAVista - custo)/(valorAVista);
		
		margemBrutaValorVista = margemBrutaValorVista * 100;
		return formataDoubleDuasCasasDecimais(margemBrutaValorVista);
	}
	
	public Double calculaMargemBrutaValorPrazo(){
		Double valorAVista = precoUnitVista;		
		Double valorJuros = pedidoItem.getValorJurosUnitario();		
		Double custo = getCusto();//pedidoItem.getProdutoPrecoRegras().getCustoKilo();
		
		if (pedidoItem.getTxCambio() != null) {
			valorAVista = valorAVista * pedidoItem.getTxCambio();
			valorJuros = valorJuros * pedidoItem.getTxCambio();
		}
		
		//custo sempre está em KG, aq verifica se a unidade é TO para multiplicar o custo se necessário
		if (pedidoItem.getUnidade().getSiglaUnidade().equals(UNIDADE_TO)){
			custo = custo * 1000;			
		}
		Double margemBrutaValorPrazo = (valorAVista + valorJuros - custo)/(valorAVista + valorJuros);
		
		margemBrutaValorPrazo = margemBrutaValorPrazo * 100;
		return formataDoubleDuasCasasDecimais(margemBrutaValorPrazo);
	}
	
	public Double calculaLucro(){
		Double custo = getCusto();
		if (pedidoItem.getUnidade().getSiglaUnidade().equals(UNIDADE_TO)){
			custo = custo * 1000;			
		}
		Double precoUnitVista = calculaPrecoUnitVista();
		if (pedidoItem.getTxCambio() != null) {
			precoUnitVista = precoUnitVista * pedidoItem.getTxCambio(); 
		}
		return formataDoubleDuasCasasDecimais(precoUnitVista - custo);
	}

	public Double calculaLucroTotal(){
		return formataDoubleDuasCasasDecimais(calculaLucro() * pedidoItem.getQuantidade());
	}
	
	public Double calculaFaturamentoTotal(){
		return formataDoubleDuasCasasDecimais(pedidoItem.getValorUnitFob() * pedidoItem.getQuantidade());
	}
	
	private Double formataDoubleDuasCasasDecimais( Double doubleIn) {
		try{
			BigDecimal b = new BigDecimal(doubleIn);
			return b.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
			//String s = String.format("%.2f", doubleIn);
			//return new Double(s.replace(',', '.'));
		} catch (Exception e) {			
			return null;			
		}
	}

	public Double getValorUnitBrutoReal() {
		this.valorUnitBrutoReal = pedidoItem.getValorUnitBruto();
		if (pedidoItem.getTxCambio() != null) {
			this.valorUnitBrutoReal = pedidoItem.getValorUnitBruto() * pedidoItem.getTxCambio();
			this.valorUnitBrutoReal = formataDoubleDuasCasasDecimais(this.valorUnitBrutoReal);
		}
		return valorUnitBrutoReal;
	}

	public void setValorUnitBrutoReal(Double valorUnitBrutoReal) {
		this.valorUnitBrutoReal = valorUnitBrutoReal;
		if (pedidoItem.getTxCambio() != null) {
			Double valorOutraMoeda = valorUnitBrutoReal;
			valorOutraMoeda = valorOutraMoeda / pedidoItem.getTxCambio();
			valorOutraMoeda = formataDoubleDuasCasasDecimais(valorOutraMoeda);
			pedidoItem.setValorUnitBruto(valorOutraMoeda);
		}
	}

	public Double getPrecoUnitVistaReal() {
		this.precoUnitVistaReal = this.precoUnitVista;
		if (pedidoItem.getTxCambio() != null) {
			this.precoUnitVistaReal = this.precoUnitVista * pedidoItem.getTxCambio();
			this.precoUnitVistaReal = formataDoubleDuasCasasDecimais(this.precoUnitVistaReal);
		}
		return precoUnitVistaReal;
	}

	public void setPrecoUnitVistaReal(Double precoUnitVistaReal) {
		this.precoUnitVistaReal = precoUnitVistaReal;
		if (pedidoItem.getTxCambio() != null) {
			Double valorOutraMoeda = precoUnitVistaReal;
			valorOutraMoeda = valorOutraMoeda / pedidoItem.getTxCambio();
			valorOutraMoeda = formataDoubleDuasCasasDecimais(valorOutraMoeda);
			this.precoUnitVista = valorOutraMoeda;
		}
	}

	public Double getValorJurosUnitarioReal() {
		this.valorJurosUnitarioReal = pedidoItem.getValorJurosUnitario();
		if (pedidoItem.getTxCambio() != null) {
			this.valorJurosUnitarioReal = pedidoItem.getValorJurosUnitario() * pedidoItem.getTxCambio();
			this.valorJurosUnitarioReal = formataDoubleDuasCasasDecimais(this.valorJurosUnitarioReal);
		}
		return valorJurosUnitarioReal;
	}

	public void setValorJurosUnitarioReal(Double valorJurosUnitarioReal) {
		this.valorJurosUnitarioReal = valorJurosUnitarioReal;
		if (pedidoItem.getTxCambio() != null) {
			Double valorOutraMoeda = valorJurosUnitarioReal;
			valorOutraMoeda = valorOutraMoeda / pedidoItem.getTxCambio();
			valorOutraMoeda = formataDoubleDuasCasasDecimais(valorOutraMoeda);
			pedidoItem.setValorJurosUnitario(valorOutraMoeda);
		}
	}

	public Double getValorFreteUnitarioReal() {
		this.valorFreteUnitarioReal = pedidoItem.getValorFreteUnitario();
		if (pedidoItem.getTxCambio() != null) {
			this.valorFreteUnitarioReal = pedidoItem.getValorFreteUnitario() * pedidoItem.getTxCambio();
			this.valorFreteUnitarioReal = formataDoubleDuasCasasDecimais(this.valorFreteUnitarioReal);
		}
		return valorFreteUnitarioReal;
	}

	public void setValorFreteUnitarioReal(Double valorFreteUnitarioReal) {
		this.valorFreteUnitarioReal = valorFreteUnitarioReal;
		if (pedidoItem.getTxCambio() != null) {
			Double valorOutraMoeda = valorFreteUnitarioReal;
			valorOutraMoeda = valorOutraMoeda / pedidoItem.getTxCambio();
			valorOutraMoeda = formataDoubleDuasCasasDecimais(valorOutraMoeda);
			pedidoItem.setValorFreteUnitario(valorOutraMoeda);
		} else {
			pedidoItem.setValorFreteUnitario(valorFreteUnitarioReal);
		}
	}

	public Double getFaturamentoTotalReal() {
		this.faturamentoTotalReal = this.faturamentoTotal;
		if (pedidoItem.getTxCambio() != null) {
			this.faturamentoTotalReal = this.faturamentoTotal * pedidoItem.getTxCambio();
			this.faturamentoTotalReal = formataDoubleDuasCasasDecimais(this.faturamentoTotalReal);
		}
		return faturamentoTotalReal;
	}

	public void setFaturamentoTotalReal(Double faturamentoTotalReal) {
		this.faturamentoTotalReal = faturamentoTotalReal;
		if (pedidoItem.getTxCambio() != null) {
			Double valorOutraMoeda = faturamentoTotalReal;
			valorOutraMoeda = valorOutraMoeda / pedidoItem.getTxCambio();
			valorOutraMoeda = formataDoubleDuasCasasDecimais(valorOutraMoeda);
			this.faturamentoTotal = valorOutraMoeda;
		}
	}

	public Double getComissaoRtvValorReal() {
		this.comissaoRtvValorReal = pedidoItem.getComissaoRtvValor();
		if (pedidoItem.getTxCambio() != null) {
			this.comissaoRtvValorReal = pedidoItem.getComissaoRtvValor() * pedidoItem.getTxCambio();
			this.comissaoRtvValorReal = formataDoubleDuasCasasDecimais(this.comissaoRtvValorReal);
		}
		return comissaoRtvValorReal;
	}

	public void setComissaoRtvValorReal(Double comissaoRtvValorReal) {
		this.comissaoRtvValorReal = comissaoRtvValorReal;
		if (pedidoItem.getTxCambio() != null) {
			Double valorOutraMoeda = comissaoRtvValorReal;
			valorOutraMoeda = valorOutraMoeda / pedidoItem.getTxCambio();
			valorOutraMoeda = formataDoubleDuasCasasDecimais(valorOutraMoeda);
			pedidoItem.setComissaoRtvValor(valorOutraMoeda);
		}
	}
}

package com.pdq.pedido.helper;

import lombok.Data;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 9 de abr de 2019
 *
 */
@Data
public class PedidoItemAprovadorIreportHelper {
	
	private String cor;
	private String produto;
	private String quantidade;
	private String un;
	private String mesespagfat;	
	private String unitbruto;
	private String icmspiscofins;
	private String jurosmes;
	private String frete;
	private String precoavista;
	private String custo;  
	private String lucro;
	private String comissaortvrs;
	private String mbvaloravista;
	private String mbvaloraprazosemicms;
	private String comissaortvpor;
	private String comissaoagentepor;
	private String comissaoagenters;
	private String comissaoagenteratio;
	private String lucrototal;
	private String faturamentototal;
	
	public PedidoItemAprovadorIreportHelper(){
		
	}
	
	public PedidoItemAprovadorIreportHelper(String cor, String produto, String quantidade, String un,
			String mesespagfat, String unitbruto, String icmspiscofins, String jurosmes, String frete,
			String precoavista, String custo, String lucro, String comissaortvrs, String mbvaloravista,
			String mbvaloraprazosemicms, String comissaortvpor, String comissaoagentepor, String comissaoagenters,
			String comissaoagenteratio, String lucrototal, String faturamentototal) {
		super();
		this.cor = cor;
		this.produto = produto;
		this.quantidade = quantidade;
		this.un = un;
		this.mesespagfat = mesespagfat;
		this.unitbruto = unitbruto;
		this.icmspiscofins = icmspiscofins;
		this.jurosmes = jurosmes;
		this.frete = frete;
		this.precoavista = precoavista;
		this.custo = custo;
		this.lucro = lucro;
		this.comissaortvrs = comissaortvrs;
		this.mbvaloravista = mbvaloravista;
		this.mbvaloraprazosemicms = mbvaloraprazosemicms;
		this.comissaortvpor = comissaortvpor;
		this.comissaoagentepor = comissaoagentepor;
		this.comissaoagenters = comissaoagenters;
		this.comissaoagenteratio = comissaoagenteratio;
		this.lucrototal = lucrototal;
		this.faturamentototal = faturamentototal;
	}
}

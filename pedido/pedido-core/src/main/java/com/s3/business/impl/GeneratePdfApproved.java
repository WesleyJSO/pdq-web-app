package com.s3.business.impl;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.TabelaPreco;
import com.s3.helper.CorPedidoHelper;
import com.s3.helper.PedidoHelper;
import com.s3.helper.PedidoItemAprovadorIreportHelper;
import com.s3.helper.PedidoItemHelper;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * 
 * @author José Wesley Silva 
 * Muralis Assessoria e Tecnologia Ltda. 
 * 23-04-2019 19:02:16
 *
 */
@Component
public class GeneratePdfApproved implements IStrategy<PedidoHelper> {

	private static final String JASPER_REPORT = "JASPER_REPORT";
	private PedidoItemAprovadorIreportHelper p = null;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {

		if (aEntity != null) {
			try {
				Map<String, Object> pdfParameters = new HashMap<>();
	
				pdfParameters.put("prmImagemPath", Thread.currentThread().getContextClassLoader()
						.getResource("jasper/compass-minerals.jpg").toURI().toString());
				pdfParameters.put("prmHoraData", LocalDate.now());
				pdfParameters.put("prmVersao", "1.0.4");
				pdfParameters.put("prmNomRegional",
						aEntity.getRegional() != null && aEntity.getRegional().getNomRegional() != null
								? aEntity.getRegional().getNomRegional() : "");
				if (aEntity.getCliente() != null) {
					pdfParameters.put("prmCodSAP", aEntity.getCodSap() != null ? aEntity.getCodSap() : "");
					pdfParameters.put("prmNome",
							aEntity.getCliente().getNomCliente() != null ? aEntity.getCliente().getNomCliente() : "");
				}
				if (!CollectionUtils.isEmpty(aEntity.getListPedidoItem())
						&& aEntity.getListPedidoItem().get(0).getProdutoPrecoRegras() != null
						&& aEntity.getListPedidoItem().get(0).getProdutoPrecoRegras().getTabelaPreco() != null) {
	
					TabelaPreco tabelaPreco = aEntity.getListPedidoItem().get(0).getProdutoPrecoRegras().getTabelaPreco();
					pdfParameters.put("prmTabelaVigencia", ""
							.concat(tabelaPreco.getTipoTabela() != null ? tabelaPreco.getTipoTabela().getDesTipoTabela() : "")
							.concat(" ").concat(tabelaPreco.getDtIni() != null ? tabelaPreco.getDtIni().toString() : "")
							.concat(" ").concat(tabelaPreco.getDtFim() != null ? tabelaPreco.getDtFim().toString() : ""));
				}
				List<PedidoItemHelper> listPedidoItemHelper = new ArrayList<>();
				for (PedidoItem pedidoItem : aEntity.getListPedidoItem()) {
					PedidoItemHelper p = new PedidoItemHelper();
					p.setPedidoItem(pedidoItem);
					p.setUnidade(pedidoItem.getUnidade());
					p.setStrFreteEspecial(pedidoItem.getFreteEspecial() ? "Sim" : "Não");
					p.setConsiderarValorFobNetPreenchido(false);
					p.setCusto(pedidoItem.getProdutoPrecoRegras().getCustoKilo());
					p.carregaValoresGrid(aEntity);
					listPedidoItemHelper.add(p);
				}
	
				double totalQuantidade = 0d;
				double totalPrecoBrutoUnit = 0d;
				double totalFreteUnit = 0d;
				double totalPrecoVista = 0d;
				double totalCusto = 0d;
				double totalMBValorVista = 0d;
				double totalMBValorPrazo = 0d;
				double totalLucro = 0d;
				double totalFaturamento = 0d;
				double totalComissaoRs = 0d;
				Double precoVistaComJuros = 0d;
				if (listPedidoItemHelper != null && !listPedidoItemHelper.isEmpty()) {
					for (PedidoItemHelper p : listPedidoItemHelper) {
						totalQuantidade += p.getPedidoItem().getVolumeTotalKg();
						
						if (p.getPedidoItem().getTxCambio() != null) {
							totalPrecoBrutoUnit += p.getPedidoItem().getValorUnitBruto() * p.getPedidoItem().getQuantidade() * p.getPedidoItem().getTxCambio();
							totalPrecoVista += p.getPrecoUnitVista() * p.getPedidoItem().getQuantidade() * p.getPedidoItem().getTxCambio();
							Double precoJurosOutraMoeda = p.getPrecoUnitVista() * p.getPedidoItem().getQuantidade() + p.getPedidoItem().getValorJurosUnitario() * p.getPedidoItem().getQuantidade();
							precoVistaComJuros += precoJurosOutraMoeda * p.getPedidoItem().getTxCambio();
							totalFreteUnit += p.getPedidoItem().getValorFrete() * p.getPedidoItem().getTxCambio();
							totalFaturamento += p.getFaturamentoTotal() * p.getPedidoItem().getTxCambio();
							totalComissaoRs += p.getPedidoItem().getComissaoRtvValor() * p.getPedidoItem().getTxCambio();
						} else {
							totalPrecoBrutoUnit += p.getPedidoItem().getValorUnitBruto() * p.getPedidoItem().getQuantidade();
							totalPrecoVista += p.getPrecoUnitVista() * p.getPedidoItem().getQuantidade();
							precoVistaComJuros += p.getPrecoUnitVista() * p.getPedidoItem().getQuantidade() + p.getPedidoItem().getValorJurosUnitario() * p.getPedidoItem().getQuantidade();
							totalFreteUnit += p.getPedidoItem().getValorFrete();
							totalFaturamento += p.getFaturamentoTotal();
							totalComissaoRs += p.getPedidoItem().getComissaoRtvValor();
						}
	
						Double custo = p.getCusto();
						if (p.getPedidoItem().getUnidade().getSiglaUnidade().equals(PedidoItemHelper.UNIDADE_TONELADA))
							custo = custo * 1000;
						
						totalCusto += (custo * p.getPedidoItem().getQuantidade());
	
						totalLucro += p.getLucroTotal();
					}
					totalMBValorVista = (totalPrecoVista - totalCusto) / totalPrecoVista;
					totalMBValorVista = totalMBValorVista * 100;
					totalMBValorPrazo = (precoVistaComJuros - totalCusto) / precoVistaComJuros;
					totalMBValorPrazo = totalMBValorPrazo * 100;
				}
	
	            pdfParameters.put("prmTotalQtd", new DecimalFormat("###,#00.00").format(totalQuantidade));
	            pdfParameters.put("prmTotalPrecoBruto", new DecimalFormat("###,#00.00").format(totalPrecoBrutoUnit));
	            pdfParameters.put("prmTotalFrete", new DecimalFormat("###,#00.00").format(totalFreteUnit));
	            pdfParameters.put("prmTotalPrecoaVista", new DecimalFormat("###,#00.00").format(totalPrecoVista));
	            pdfParameters.put("prmTotalCusto", new DecimalFormat("###,#00.00").format(totalCusto));
	            pdfParameters.put("prmTotalMBaVista", new DecimalFormat("###,#00.00").format(totalMBValorVista));
	            pdfParameters.put("prmTotalMBaPrazo", new DecimalFormat("###,#00.00").format(totalMBValorPrazo));
	            pdfParameters.put("prmTotalLucro", new DecimalFormat("###,#00.00").format(totalLucro));
	            pdfParameters.put("prmTotalFaturamento", new DecimalFormat("###,#00.00").format(totalFaturamento));
	            pdfParameters.put("prmTotalComissaoRS", new DecimalFormat("###,#00.00").format(totalComissaoRs));
				
	            List < PedidoItemAprovadorIreportHelper > listPedidoItemPdf = new ArrayList < PedidoItemAprovadorIreportHelper >();
	            if (!CollectionUtils.isEmpty(aEntity.getListPedidoItem())) {
	            	listPedidoItemHelper.forEach(element -> {
	            		p = new PedidoItemAprovadorIreportHelper();
	            		long idCor = element.getPedidoItem().getCorPedido().getId();
	            		p.setCor(idCor == CorPedidoHelper.AZUL ? "Azul" 
	            				: idCor == CorPedidoHelper.AMARELO ? "Amarelo" 
	    						: idCor == CorPedidoHelper.VERDE ? "Verde" 
								: idCor == CorPedidoHelper.VERMELHO ? "Vermelho"
								: idCor == CorPedidoHelper.PRETO ? "Preto" : "");
	            		String product = element.getPedidoItem().getProdutoPrecoRegras().getProduto().getDesProduto(); 
	                    p.setProduto(product.length() > 50 ? product.substring(0, 50) : product);
	                    p.setQuantidade(new DecimalFormat("###,#00.00").format(element.getPedidoItem().getQuantidade()));
	                    p.setUn(element.getPedidoItem().getUnidade().getSiglaUnidade());
	                    p.setMesespagfat(new DecimalFormat("###,#00.00").format(element.getMesesPagamentoAposFaturamento()));
	                    p.setUnitbruto(new DecimalFormat("###,#00.00").format(element.getValorUnitBrutoReal()));
	                    p.setIcmspiscofins(new DecimalFormat("###,#00.00").format(element.getTotalPorcentImpostos()));
	                    p.setJurosmes(new DecimalFormat("###,#00.00").format(element.getTaxaJuros()));
	                    p.setFrete(new DecimalFormat("###,#00.00").format(element.getValorFreteUnitarioReal()));
	                    p.setPrecoavista(new DecimalFormat("###,#00.00").format(element.getPrecoUnitVistaReal()));
	                    p.setCusto(new DecimalFormat("###,#00.00").format(element.getCusto()));
	                    p.setLucro(new DecimalFormat("###,#00.00").format(element.calculaLucro()));
	                    p.setComissaortvrs(new DecimalFormat("###,#00.00").format(element.getPedidoItem().getComissaoRtvValor()));
	                    p.setMbvaloravista(new DecimalFormat("###,#00.00").format(element.getMargemBrutaValorVista()));
	                    p.setMbvaloraprazosemicms(new DecimalFormat("###,#00.00").format(element.getMargemBrutaValorPrazo()));
	                    p.setComissaortvpor(new DecimalFormat("###,#00.00").format(element.getPedidoItem().getComissaoRtvPorcent()));
	                    p.setComissaoagentepor(new DecimalFormat("###,#00.00").format(element.getPedidoItem().getAgenteFixoPorcent()));
	                    p.setComissaoagenters(new DecimalFormat("###,#00.00").format(element.getPedidoItem().getAgenteFixoValorPorKilo()));
	                    listPedidoItemPdf.add(p);
	            	});
	            }
	            JasperReport jasperRepost = JasperCompileManager.compileReport(Thread.currentThread()
	            		.getContextClassLoader().getResourceAsStream("jasper/tabelaItensAprovador.jrxml"));
	            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperRepost, 
	            		pdfParameters, new JRBeanCollectionDataSource(listPedidoItemPdf));
	            
	            aCase.getResult().addEntity(JASPER_REPORT, jasperPrint);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		aCase.getResult().setMessage("Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

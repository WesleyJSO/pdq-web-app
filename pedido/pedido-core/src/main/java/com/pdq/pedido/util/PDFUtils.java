package com.pdq.pedido.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.CorPedidoHelper;
import com.pdq.pedido.helper.PedidoItemAprovadorIreportHelper;
import com.pdq.pedido.helper.PedidoItemHelper;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PDFUtils {
	
	private final static String UNIDADE_TO = "TO";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(propagation = Propagation.SUPPORTS)
	public static JasperPrint generateApproverPDF(Pedido pedido, List<PedidoItem> listPedidoItens) {

		try {

			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dh = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			DecimalFormat d = new DecimalFormat(",000.00");
			DecimalFormat d2 = new DecimalFormat("00.00");

			// Setando os parâmetros
			Map parametro = new HashMap();

			// Logo
			String pathIMG = Thread.currentThread().getContextClassLoader()
					.getResource("jasper/compass-minerals-pdq.jpg").toURI().toString();

			parametro.put("prmImagemPath", pathIMG);

			String dataHora = dh.format(new Date());

			parametro.put("prmHoraData", dataHora);

			parametro.put("prmVersao", "1.0.4");

			parametro.put("prmNomRegional",
					pedido.getRegional().getNomRegional() != null ? pedido.getRegional().getNomRegional() : "");

			// Dados do cliente
			if (pedido.getCliente() != null) {

				parametro.put("prmCodSAP", pedido.getCodSap() != null ? pedido.getCodSap() : "");
				parametro.put("prmNome",
						pedido.getCliente().getNomCliente() != null ? pedido.getCliente().getNomCliente() : "");
			}

			// Setando a Lista de produtos no iReport
			List<PedidoItem> produtos = listPedidoItens;

			if (!produtos.isEmpty()) {

				// Seta o campo tabela de vigência
				String dataInicio = "";
				String dataFim = "";
				String tabela = "";
				if (produtos.get(0).getProdutoPrecoRegras().getTabelaPreco() != null) {
					dataInicio = produtos.get(0).getProdutoPrecoRegras().getTabelaPreco().getDtIni() != null
							? dt.format(produtos.get(0).getProdutoPrecoRegras().getTabelaPreco().getDtIni()) : "";
					dataFim = produtos.get(0).getProdutoPrecoRegras().getTabelaPreco().getDtFim() != null
							? dt.format(produtos.get(0).getProdutoPrecoRegras().getTabelaPreco().getDtFim()) : "";
					tabela = produtos.get(0).getProdutoPrecoRegras().getTabelaPreco().getTipoTabela() != null ? produtos
							.get(0).getProdutoPrecoRegras().getTabelaPreco().getTipoTabela().getDesTipoTabela() : "";
				}
				parametro.put("prmTabelaVigencia", tabela + " " + dataInicio + " " + dataFim);
			}

			/**
			 * Calcula os valores totais do pedido
			 */
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

			List<PedidoItemHelper> lstPedidoItemHelper = new ArrayList<PedidoItemHelper>();
			for (PedidoItem pItem : produtos) {
				PedidoItemHelper pItemHelper = new PedidoItemHelper();
				pItemHelper.setPedidoItem(pItem);
				pItemHelper.setUnidade(pItem.getUnidade());
				pItemHelper.setStrFreteEspecial(pItem.getFreteEspecial() ? "Sim" : "Não");
				pItemHelper.setConsiderarValorFobNetPreenchido(false);
				pItemHelper.setCusto(pItem.getProdutoPrecoRegras().getCustoKilo());
				pItemHelper.carregaValoresGrid(pedido);
				lstPedidoItemHelper.add(pItemHelper);
			}

			Double precoVistaComJuros = 0d;
			if (lstPedidoItemHelper != null && !lstPedidoItemHelper.isEmpty()) {
				for (PedidoItemHelper pih : lstPedidoItemHelper) {
					// totalQuantidade += pih.getPedidoItem().getQuantidade();
					totalQuantidade += pih.getPedidoItem().getVolumeTotalEmKg();
					if (pih.getPedidoItem().getTxCambio() != null) {
						totalPrecoBrutoUnit += (pih.getPedidoItem().getValorUnitBruto()
								* pih.getPedidoItem().getQuantidade() * pih.getPedidoItem().getTxCambio());
						totalPrecoVista += (pih.getPrecoUnitVista() * pih.getPedidoItem().getQuantidade()
								* pih.getPedidoItem().getTxCambio());
						Double precoJurosOutraMoeda = (pih.getPrecoUnitVista() * pih.getPedidoItem().getQuantidade())
								+ (pih.getPedidoItem().getValorJurosUnitario() * pih.getPedidoItem().getQuantidade());
						precoVistaComJuros += (precoJurosOutraMoeda * pih.getPedidoItem().getTxCambio());
						totalFreteUnit += (pih.getPedidoItem().getValorFrete() * pih.getPedidoItem().getTxCambio());
						totalFaturamento += pih.getFaturamentoTotal() * pih.getPedidoItem().getTxCambio();
						totalComissaoRs += pih.getPedidoItem().getComissaoRtvValor()
								* pih.getPedidoItem().getTxCambio();
					} else {
						totalPrecoBrutoUnit += (pih.getPedidoItem().getValorUnitBruto()
								* pih.getPedidoItem().getQuantidade());
						totalPrecoVista += (pih.getPrecoUnitVista() * pih.getPedidoItem().getQuantidade());
						precoVistaComJuros += (pih.getPrecoUnitVista() * pih.getPedidoItem().getQuantidade())
								+ (pih.getPedidoItem().getValorJurosUnitario() * pih.getPedidoItem().getQuantidade());
						totalFreteUnit += (pih.getPedidoItem().getValorFrete());
						totalFaturamento += pih.getFaturamentoTotal();
						totalComissaoRs += pih.getPedidoItem().getComissaoRtvValor();
					}

					Double custo = pih.getCusto();// pedidoItem.getProdutoPrecoRegras().getCustoKilo();
					// custo sempre está em KG, aq verifica se a unidade é TO
					// para multiplicar o custo se necessário
					if (pih.getPedidoItem().getUnidade().getSiglaUnidade().equals(UNIDADE_TO)) {
						custo = custo * 1000;
					}
					totalCusto += (custo * pih.getPedidoItem().getQuantidade());

					totalLucro += pih.getLucroTotal();
					// totalMBValorVista += pih.getMargemBrutaValorVista();
					// totalMBValorPrazo += pih.getMargemBrutaValorPrazo();
				}
				totalMBValorVista = (totalPrecoVista - totalCusto) / totalPrecoVista;
				totalMBValorVista = totalMBValorVista * 100;
				totalMBValorPrazo = (precoVistaComJuros - totalCusto) / precoVistaComJuros;
				totalMBValorPrazo = totalMBValorPrazo * 100;
			}

			/**
			 * Adiciona os valores totais no parametro
			 */
			parametro.put("prmTotalQtd",
					totalQuantidade > 99.99d ? d.format(totalQuantidade) : d2.format(totalQuantidade));
			parametro.put("prmTotalPrecoBruto",
					totalPrecoBrutoUnit > 99.99d ? d.format(totalPrecoBrutoUnit) : d2.format(totalPrecoBrutoUnit));
			parametro.put("prmTotalFrete",
					totalFreteUnit > 99.99d ? d.format(totalFreteUnit) : d2.format(totalFreteUnit));
			parametro.put("prmTotalPrecoaVista",
					totalPrecoVista > 99.99d ? d.format(totalPrecoVista) : d2.format(totalPrecoVista));
			parametro.put("prmTotalCusto", totalCusto > 99.99d ? d.format(totalCusto) : d2.format(totalCusto));
			parametro.put("prmTotalMBaVista",
					totalMBValorVista > 99.99d ? d.format(totalMBValorVista) : d2.format(totalMBValorVista));
			parametro.put("prmTotalMBaPrazo",
					totalMBValorPrazo > 99.99d ? d.format(totalMBValorPrazo) : d2.format(totalMBValorPrazo));
			parametro.put("prmTotalLucro", totalLucro > 99.99d ? d.format(totalLucro) : d2.format(totalLucro));
			parametro.put("prmTotalFaturamento",
					totalFaturamento > 99.99d ? d.format(totalFaturamento) : d2.format(totalFaturamento));
			parametro.put("prmTotalComissaoRS",
					totalComissaoRs > 99.99d ? d.format(totalComissaoRs) : d2.format(totalComissaoRs));

			// Atributo para armazenar o total do pedido
			Double totalPedido = 0d;

			// Se existir produtos ele insere na lista de produtos
			List<PedidoItemAprovadorIreportHelper> listaDeprodutos = new ArrayList<PedidoItemAprovadorIreportHelper>();
			if (!produtos.isEmpty()) {
				// Prepara a lista de produtos para imprimir no iReport
				listaDeprodutos = montarListaItensAprovador(lstPedidoItemHelper, pedido, totalPedido);
			}

			// Caminho do arquivo Jasper
			// String path =
			// FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/jasper/tabelaItensAprovador.jrxml");

			// Gerando o PDF
			JasperReport relatorio = JasperCompileManager.compileReport(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("jasper/tabelaItensAprovador.jrxml"));
			return JasperFillManager.fillReport(relatorio, parametro, new JRBeanCollectionDataSource(listaDeprodutos));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static List < PedidoItemAprovadorIreportHelper > montarListaItensAprovador ( List < PedidoItemHelper > lstPedidoItemHelper , Pedido pedido , Double totalPedido ) {
        List < PedidoItemAprovadorIreportHelper > lista = new ArrayList < PedidoItemAprovadorIreportHelper >();

        PedidoItemAprovadorIreportHelper item = null;
        
        DecimalFormat quantidadeDezena = new DecimalFormat( "00.000" );
        DecimalFormat quantidadeCentena = new DecimalFormat( ",000.000" );
        DecimalFormat d = new DecimalFormat( "00.00" );
        DecimalFormat d2 = new DecimalFormat( ",000.00" );

        // int cont = 1;
        for ( PedidoItemHelper pih : lstPedidoItemHelper ) {
            item = new PedidoItemAprovadorIreportHelper();
            String produto = pih.getPedidoItem().getProdutoPrecoRegras().getProduto().getDesProduto();

            // Descobre a cor do item
            String cor = "";
            long idCor = pih.getPedidoItem().getCorPedido().getId();
            if ( idCor == CorPedidoHelper.ID_AZUL ) 
                cor = "Azul";
            else if ( idCor == CorPedidoHelper.ID_AMARELO ) 
                cor = "Amarelo";
            else if ( idCor == CorPedidoHelper.ID_VERDE ) 
                cor = "Verde";
            else if ( idCor == CorPedidoHelper.ID_VERMELHO ) 
                cor = "Vermelho";
            else if ( idCor == CorPedidoHelper.ID_PRETO ) 
                cor = "Preto";
            

            item.setCor( cor );
            item.setProduto( produto.length() > 50 ? produto.substring( 0 , 50 ) : produto );
            item.setQuantidade(
                    pih.getPedidoItem().getQuantidade() > 99.99d ? quantidadeCentena.format( pih.getPedidoItem().getQuantidade() ).toString() : quantidadeDezena.format( pih.getPedidoItem().getQuantidade() ).toString() );
            item.setUn( pih.getPedidoItem().getUnidade().getSiglaUnidade() );
            item.setMesespagfat(
                    pih.getMesesPagamentoAposFaturamento() > 99.99d ? d2.format( pih.getMesesPagamentoAposFaturamento() ).toString() : d.format( pih.getMesesPagamentoAposFaturamento() ).toString() );
            item.setUnitbruto( pih.getValorUnitBrutoReal() > 99.99d ? d2.format( pih.getValorUnitBrutoReal() ).toString() : d.format( pih.getValorUnitBrutoReal() ).toString() );
            item.setIcmspiscofins( pih.getTotalPorcentImpostos() > 99.99d ? d2.format( pih.getTotalPorcentImpostos() ).toString() : d.format( pih.getTotalPorcentImpostos() ).toString() );
            item.setJurosmes( pih.getTaxaJuros() > 99.99d ? d2.format( pih.getTaxaJuros() ).toString() : d.format( pih.getTaxaJuros() ).toString() );
            item.setFrete( pih.getValorFreteUnitarioReal() > 99.99d ? d2.format( pih.getValorFreteUnitarioReal() ).toString() : d.format( pih.getValorFreteUnitarioReal() ).toString() );
            item.setPrecoavista( pih.getPrecoUnitVistaReal() > 99.99d ? d2.format( pih.getPrecoUnitVistaReal() ).toString() : d.format( pih.getPrecoUnitVistaReal() ).toString() );
            item.setCusto( pih.getCusto() > 99.99d ? d2.format( pih.getCusto() ).toString() : d.format( pih.getCusto() ).toString() );
            item.setLucro( pih.calculaLucro() > 99.99d ? d2.format( pih.calculaLucro() ).toString() : d.format( pih.calculaLucro() ).toString() );
            item.setComissaortvrs( pih.getPedidoItem().getComissaoRtvValor() > 99.99d ? d2.format( pih.getPedidoItem().getComissaoRtvValor() ).toString()
                    : d.format( pih.getPedidoItem().getComissaoRtvValor() ).toString() );
            item.setMbvaloravista( pih.getMargemBrutaValorVista() > 99.99d ? d2.format( pih.getMargemBrutaValorVista() ).toString() : d.format( pih.getMargemBrutaValorVista() ).toString() );
            item.setMbvaloraprazosemicms( pih.getMargemBrutaValorPrazo() > 99.99d ? d2.format( pih.getMargemBrutaValorPrazo() ).toString() : d.format( pih.getMargemBrutaValorPrazo() ).toString() );
            item.setComissaortvpor( pih.getPedidoItem().getComissaoRtvPorcent() > 99.99d ? d2.format( pih.getPedidoItem().getComissaoRtvPorcent() ).toString()
                    : d.format( pih.getPedidoItem().getComissaoRtvPorcent() ).toString() );
            item.setComissaoagentepor( pih.getPedidoItem().getAgenteFixoPorcent() > 99.99d ? d2.format( pih.getPedidoItem().getAgenteFixoPorcent() ).toString()
                    : d.format( pih.getPedidoItem().getAgenteFixoPorcent() ).toString() );
            item.setComissaoagenters( pih.getPedidoItem().getAgenteFixoValorPorKilo() > 99.99d ? d2.format( pih.getPedidoItem().getAgenteFixoValorPorKilo() ).toString()
                    : d.format( pih.getPedidoItem().getAgenteFixoValorPorKilo() ).toString() );

            if ( pih.getPedidoItem().getAgenteRateioPorcentSap() != null ) {
                item.setComissaoagenteratio( pih.getPedidoItem().getAgenteRateioPorcentSap() > 99.99d ? d2.format( pih.getPedidoItem().getAgenteRateioPorcentSap() ).toString()
                        : d.format( pih.getPedidoItem().getAgenteRateioPorcentSap() ).toString() );
            } else {
                item.setComissaoagenteratio( "" );
            }

            item.setLucrototal( pih.getLucroTotal() > 99.99d ? d2.format( pih.getLucroTotal() ).toString() : d.format( pih.getLucroTotal() ).toString() );
            item.setFaturamentototal( pih.getFaturamentoTotalReal() > 99.99d ? d2.format( pih.getFaturamentoTotalReal() ).toString() : d.format( pih.getFaturamentoTotalReal() ).toString() );

            lista.add( item );

        }

        return lista;

    }
}

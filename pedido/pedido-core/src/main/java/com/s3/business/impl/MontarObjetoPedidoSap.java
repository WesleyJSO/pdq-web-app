package com.s3.business.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.google.common.base.Strings;
import com.pdq.pedido.dao.impl.FuncionarioDAO;
import com.pdq.pedido.domain.Funcionario;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.ParametroHelper;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.repository.ParametroRepository;
import com.pdq.pedido.repository.PedidoRepository;
import com.s3.sap.z_pedido_novo_sap.TableOfZsdePedidoWebs;
import com.s3.sap.z_pedido_novo_sap.ZsdePedidoWebs;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 11-04-2019 15:09:21
 *
 */
@Component
public class MontarObjetoPedidoSap implements IStrategy<PedidoHelper> {

	private static final DateTimeFormatter dateFormat = DateTimeFormatter.BASIC_ISO_DATE;
	private static final String userDateFormat = "dd/MM/yyyy";
	private static final String int4dec5 = "0000.00000";
	private static final String int9dec3 = "000000000.000";
	private static final String int9dec2 = "000000000.00";
	private final String TIPO_FRETE_CIF = "CIF";
	private final String V002 = "V002";
	private final String V003 = "V003";
	private final String[] tipoAgenciamento = { "NENHUM", "FIXO", "AGENTE COMISSAO" };
	
	@Autowired private FuncionarioDAO funcionarioDAO;
	@Autowired private ParametroRepository parametroRepository;
	private TableOfZsdePedidoWebs pedidoSap;
	
	@Autowired private PedidoRepository pedidoRepository;
	/**
	 * Get each order item from the order and put it into a SAP object,
	 * creates a SAP's order object with order items ready to send to SAP.
	 */
	@Override
	public void process(PedidoHelper bEntity, INavigationCase<PedidoHelper> aCase) {

		Pedido aEntity = pedidoRepository.findById("8a43f82e5333658101533e7e347201b6").get();
		
		if (aEntity != null) {
			Optional<Funcionario> funcionario = funcionarioDAO.findById(aEntity.getUsuarioRtv().getId(), new Funcionario());
            Optional<Funcionario> funcionarioResponsavelComissao = funcionarioDAO.findById(aEntity.getUsuarioResponsavelComissao().getId(), new Funcionario());
			
            pedidoSap = new TableOfZsdePedidoWebs();
			int itemIndex = 0;
			for (PedidoItem pedidoItem : aEntity.getListPedidoItem()) {

                String idSequencia = String.format("%03d" , ++itemIndex);
                String tpPedido = aEntity.getTipoVenda().getCodTipoVenda();
                String nrPedido = aEntity.getCodSap();
                String dtPedido = dateFormat.format(aEntity.getDtCriacaoPedido());
                String nrPedidoCli = Strings.isNullOrEmpty(aEntity.getNumPedidoCli())
                		? "" : aEntity.getNumPedidoCli();
                String cdEmissor = aEntity.getCliente().getCodSap().toString();
                String cdRecebedor = aEntity.getClienteEntrega().getCodSap().toString();
                String cdPagador = aEntity.getClienteCobranca().getCodSap().toString();
                String cdMotivoOrd = aEntity.getBarter() 
                		? "Z16" : aEntity.getCampanha() 
        				? "Z12" : "";
                String cdMoeda = pedidoItem.getMoeda().getDesSigla();
                String cdOrgVenda = pedidoItem.getOrganizacaoVendas().getCodOrganizacaoVendas();
                String cdCanalDistr = aEntity.getCliente().getCanalDistribuicao() != null
                		? aEntity.getCliente().getCanalDistribuicao().getCodCanalDistribuicao()
        				: "";
                
                String cdSetAtiv = aEntity.getSetorAtividade().getCodSetorAtividade().toString().trim();
                String cdMaterial = String.format("%018d", pedidoItem.getProdutoPrecoRegras().getProduto().getIdProduto());
                String dcMaterial = pedidoItem.getProdutoPrecoRegras().getProduto().getDesProduto();
                String cdUtilMat = pedidoItem.getCultura().getCodCultura().toString();
                String cdCentro = pedidoItem.getFabrica().getCodFabrica();
                String cdIncoterms = pedidoItem.getTipoFrete().equals(TIPO_FRETE_CIF)
                		? TIPO_FRETE_CIF
        				: "FOB";
                String condPagto = pedidoItem.getCondicaoPagamento().getCodSap();
                String qtMaterial = new DecimalFormat(int9dec3).format(pedidoItem.getQuantidade()).replace(",", "");
                String vlUnMaterial = new DecimalFormat(int9dec2).format(pedidoItem.getValorUnitBruto()).replace(",", "");
                String unMedVenda = pedidoItem.getUnidade().getSiglaUnidade();
                String txCambio = pedidoItem.getTxCambio() == null
                		? "000000000"
        				: new DecimalFormat(int4dec5).format(pedidoItem.getTxCambio()).replace(",", "");
                String dtTxCambio = pedidoItem.getDtTxCambio() == null 
                		? "00000000"
        				: dateFormat.format(pedidoItem.getDtTxCambio());
                String cdCentroLucro = aEntity.getRegional().getCentroLucro() != null
                		? aEntity.getRegional().getCentroLucro().getCodSap()
        				: "";
                String dtRemessa = dateFormat.format(pedidoItem.getDataFaturamento());
                String unPreco = "00000";
                String cdAgFrete = aEntity.getTransportadora() != null
                		&& aEntity.getTransportadora().getCodSap() != null
        				? aEntity.getTransportadora().getCodSap()
						: "";
                String vlFrete = pedidoItem.getValorFrete() == null
                		? new DecimalFormat(int9dec2).format(0d).replace(",", "")
        				: new DecimalFormat(int9dec2).format(pedidoItem.getValorFrete()).replace(",", "");	
        		String cdSupVda = funcionario.isPresent() && pedidoItem.getComissaoRtvPorcent() > 0d
        				? funcionario.get().getCodSap()
        				: "";
        		String perComisSup = new DecimalFormat(int9dec3).format(pedidoItem.getComissaoRtvPorcent()).replace(",", "");

        		 
                 boolean agenciado = aEntity.getVendaAgenciada() 
                		 && !pedidoItem.getTipoAgenciamento().equals(tipoAgenciamento[0]); // nenhum
                 boolean agenciadoFixo = aEntity.getVendaAgenciada()
                		 && pedidoItem.getAgenteFixoPorcent().equals(0d)
                		 && pedidoItem.getTipoAgenciamento().equals(tipoAgenciamento[1]); // agente fixo
                 boolean agenteFixo = pedidoItem.getAgenteFixoPorcent() != null 
                		 && pedidoItem.getAgenteFixoPorcent() > 0;
        		 boolean agentePorcentagem = pedidoItem.getAgenteRateioPorcent() != null 
        				 && pedidoItem.getAgenteRateioPorcent() > 0 
        				 && pedidoItem.getAgenteRateioPorcentSap() != null;
        				 
                 String cdVendedor = agenciado
                		 ? aEntity.getVendedorAgenciado().getCodVendedorSap()
        				 : "";
                 String perComisVen = agenciado && agenteFixo
                		 ? new DecimalFormat(int9dec3).format(pedidoItem.getAgenteFixoPorcent()).replace(",", "")
        				 : "";
        		 perComisVen = perComisVen == "" && agentePorcentagem
        				 ? new DecimalFormat(int9dec3).format(pedidoItem.getAgenteRateioPorcentSap()).replace(",", "")
						 : perComisVen;
				 String cdVenEstat = agenciadoFixo
						 ? funcionarioResponsavelComissao.get().getCodSap()
						 : "";
				 cdVendedor = cdVenEstat != ""
						 ? ""
						 : cdVendedor;
				 cdVenEstat = funcionario.get().getCodSap() != null
						 && pedidoItem.getComissaoRtvPorcent().equals(0d)
						 ? funcionario.get().getCodSap()
						 : cdVenEstat;
				
                String dcTextoNf1 = !Strings.isNullOrEmpty(pedidoItem.getProdutoPrecoRegras().getObservacaoGpNf())
                		? pedidoItem.getProdutoPrecoRegras().getObservacaoGpNf()
        				: "";
                if (dcTextoNf1.length() > 132)
                    dcTextoNf1 = dcTextoNf1.substring(0, 132);

                String dcTextoNf2 = !Strings.isNullOrEmpty(nrPedidoCli.toString())
                		? "Numero pedido Cliente: ".concat(nrPedidoCli)
        				: "";
                if (dcTextoNf2.length() > 132)
                    dcTextoNf2 = dcTextoNf2.substring(0, 132);
                
                String dcTextoNf3 = !Strings.isNullOrEmpty(aEntity.getNumeroColeta())
                		? "Numero Coleta: ".concat(aEntity.getNumeroColeta())
        				: ""; 
                if(dcTextoNf3.length() > 132) 
                    dcTextoNf3 = dcTextoNf3.substring(0, 132);
                    
                String dcTextoNf4 = pedidoItem.getCondicaoPagamento().getCondPagamento().toUpperCase().contains("CRED. RURAL")
                		? parametroRepository
                    		.findById(ParametroHelper.PARAMETER_CREDITO_RURAL)
                    		.get()
                    		.getValParametro()
                    		.concat(" ")
                    		.concat(new SimpleDateFormat(userDateFormat)
                    				.format(aEntity.getDtCreditoRural()))
                		: "";
                    		
                String dcTextoCar1 = "Embalagem: "
                		.concat(pedidoItem.getEmbalagem())
        				.concat(" Cod Produto: ")
        				.concat(pedidoItem.getProdutoPrecoRegras().getProduto().getIdProduto().toString());
                String dcTextoCar2 = !Strings.isNullOrEmpty(aEntity.getNumeroAr())
                		? "AR: ".concat(aEntity.getNumeroAr())
        				: "";
	            String dcTextoCar3 = "";
	            String dcTextoCar4 = "";
                
	            String dcTextoTra = !Strings.isNullOrEmpty(aEntity.getDescricaoRota())
	            		? "Rota: ".concat(aEntity.getDescricaoRota())
        				: "";        				
                if(!Strings.isNullOrEmpty(aEntity.getObservacao()))
                    if ( dcTextoTra.length() > 0 )
                        dcTextoTra.concat( " " );
                    dcTextoTra = dcTextoTra.concat("Obs: ").concat(aEntity.getObservacao());
                    
                String dcTextoTra1 = "";
                String dcTextoTra2 = "";
                String dcTextoTra3 = "";
                String dcTextoTra4 = "";
                if(dcTextoTra.length() > 0) {
                    dcTextoTra1 = dcTextoTra;
                    if(dcTextoTra1.length() > 132) {
                        dcTextoTra2 = dcTextoTra1.substring(132);
                        dcTextoTra1 = dcTextoTra1.substring(0, 132);
                        if(dcTextoTra2.length() > 132) {
                            dcTextoTra3 = dcTextoTra2.substring(132);
                            dcTextoTra2 = dcTextoTra2.substring(0, 132);
                            if(dcTextoTra3.length() > 132) {
                                dcTextoTra4 = dcTextoTra3.substring(132);
                                dcTextoTra3 = dcTextoTra3.substring(0, 132);
                                if(dcTextoTra4.length() > 132) {
                                    dcTextoTra4 = dcTextoTra4.substring(0, 132);
                                }
                            }
                        }
                    }
                }
                String dcTextoCom1 = "";
                String dcTextoCom2 = "";
                String dcTextoCom3 = "";
                String dcTextoCom4 = "";
                
                String nrOrdVenda = pedidoItem.getCodOrdemSap();
                String tpEmb = !Strings.isNullOrEmpty(pedidoItem.getProdutoPrecoRegras().getTipoEmbalagem())
                		? pedidoItem.getProdutoPrecoRegras().getTipoEmbalagem()
        				: "";
        		String dtFixa = pedidoItem.getCondicaoPagamento().getCodSap().equals(V002) 
        				|| pedidoItem.getCondicaoPagamento().getCodSap().equals(V003)
        				? dateFormat.format(pedidoItem.getDataPagamento())
						: "";
                
				pedidoSap.getItem().add(addItemPedidoToList(
						idSequencia, tpPedido, nrPedido, dtPedido, nrPedidoCli,
						cdEmissor, cdRecebedor, cdPagador, cdMotivoOrd, cdMoeda,
						cdOrgVenda, cdCanalDistr, cdSetAtiv, cdMaterial, dcMaterial,
						cdUtilMat, cdCentro, cdIncoterms, condPagto, qtMaterial, 
						vlUnMaterial, unMedVenda, txCambio, dtTxCambio, cdCentroLucro,
						dtRemessa, unPreco, cdAgFrete, vlFrete, cdSupVda, 
						perComisSup, cdVendedor, perComisVen, dcTextoNf1, dcTextoNf2, 
						dcTextoNf3, dcTextoNf4, dcTextoCar1, dcTextoCar2, dcTextoCar3, 
						dcTextoCar4, dcTextoTra1, dcTextoTra2, dcTextoTra3, dcTextoTra4, 
						dcTextoCom1, dcTextoCom2, dcTextoCom3, dcTextoCom4, nrOrdVenda, 
						tpEmb, dtFixa, cdVenEstat));
			}
		}
		if(pedidoSap != null && pedidoSap.getItem().size() > 0) {
			aCase.getResult().addEntity(pedidoSap);
		} else {
			aCase.getResult().setError();
			aCase.getResult().setMessage("Erro ao gerar pedido para enviar para SAP.");
			aCase.suspendExecution();
		}
	}
	/**
	 * 
	 * @author José Wesley Silva
	 * 11-04-2019 15:05:32
	 *
	 * @param idSequencia
	 * @param tpPedido
	 * @param nrPedido
	 * @param dtPedido
	 * @param nrPedidoCli
	 * @param cdEmissor
	 * @param cdRecebedor
	 * @param cdPagador
	 * @param cdMotivoOrd
	 * @param cdMoeda
	 * @param cdOrgVenda
	 * @param cdCanalDistr
	 * @param cdSetAtiv
	 * @param cdMaterial
	 * @param dcMaterial
	 * @param cdUtilMat
	 * @param cdCentro
	 * @param cdIncoterms
	 * @param condPagto
	 * @param qtMaterial
	 * @param vlUnMaterial
	 * @param unMedVenda
	 * @param txCambio
	 * @param dtTxCambio
	 * @param cdCentroLucro
	 * @param dtRemessa
	 * @param unPreco
	 * @param cdAgFrete
	 * @param vlFrete
	 * @param cdSupVda
	 * @param perComisSup
	 * @param cdVendedor
	 * @param perComisVen
	 * @param dcTextoNf1
	 * @param dcTextoNf2
	 * @param dcTextoNf3
	 * @param dcTextoNf4
	 * @param dcTextoCar1
	 * @param dcTextoCar2
	 * @param dcTextoCar3
	 * @param dcTextoCar4
	 * @param dcTextoTra1
	 * @param dcTextoTra2
	 * @param dcTextoTra3
	 * @param dcTextoTra4
	 * @param dcTextoCom1
	 * @param dcTextoCom2
	 * @param dcTextoCom3
	 * @param dcTextoCom4
	 * @param nrOrdVenda
	 * @param tpEmb
	 * @param dtFixa
	 * @param cdVenEstat
	 * @return Order item in the SAP object
	 */
	private ZsdePedidoWebs addItemPedidoToList(
			String idSequencia, String tpPedido, String nrPedido, String dtPedido, String nrPedidoCli, 
			String cdEmissor, String cdRecebedor, String cdPagador, String cdMotivoOrd, String cdMoeda, 
			String cdOrgVenda, String cdCanalDistr, String cdSetAtiv, String cdMaterial, String dcMaterial, 
			String cdUtilMat, String cdCentro, String cdIncoterms, String condPagto, String qtMaterial, 
			String vlUnMaterial, String unMedVenda, String txCambio, String dtTxCambio, String cdCentroLucro,
			String dtRemessa, String unPreco, String cdAgFrete, String vlFrete, String cdSupVda, 
			String perComisSup, String cdVendedor, String perComisVen, String dcTextoNf1, String dcTextoNf2, 
			String dcTextoNf3, String dcTextoNf4, String dcTextoCar1, String dcTextoCar2, String dcTextoCar3, 
			String dcTextoCar4, String dcTextoTra1, String dcTextoTra2, String dcTextoTra3, String dcTextoTra4, 
			String dcTextoCom1, String dcTextoCom2, String dcTextoCom3, String dcTextoCom4, String nrOrdVenda, 
			String tpEmb, String dtFixa, String cdVenEstat) {

		ZsdePedidoWebs itemPedido = new ZsdePedidoWebs();
		
		itemPedido.setIdSequencia(idSequencia);
		itemPedido.setTpPedido(tpPedido);
		itemPedido.setNrPedido(nrPedido);
		itemPedido.setDtPedido(dtPedido);
		itemPedido.setNrPedidoCli(nrPedidoCli);
		
		itemPedido.setCdEmissor(cdEmissor);
		itemPedido.setCdRecebedor(cdRecebedor);
		itemPedido.setCdPagador(cdPagador);
		itemPedido.setCdMotivoOrd(cdMotivoOrd);
		itemPedido.setCdMoeda(cdMoeda);

		itemPedido.setCdOrgVenda(cdOrgVenda);
		itemPedido.setCdCanalDistr(cdCanalDistr);
		itemPedido.setCdSetAtiv(cdSetAtiv);
		itemPedido.setCdMaterial(cdMaterial);
		itemPedido.setDcMaterial(dcMaterial);
		
		itemPedido.setCdUtilMat(cdUtilMat);
		itemPedido.setCdCentro(cdCentro);
		itemPedido.setCdIncoterms(cdIncoterms);
		itemPedido.setCondPagto(condPagto);
		itemPedido.setQtMaterial(qtMaterial);
		
		itemPedido.setVlUnMaterial(vlUnMaterial);
		itemPedido.setUnMedVenda(unMedVenda);
		itemPedido.setTxCambio(txCambio);
		itemPedido.setDtTxCambio(dtTxCambio);
		itemPedido.setCdCentroLucro(cdCentroLucro);

		itemPedido.setDtRemessa(dtRemessa);
		itemPedido.setUnPreco(unPreco);
		itemPedido.setCdAgFrete(cdAgFrete);
		itemPedido.setVlFrete(vlFrete);
		itemPedido.setCdSupVda(cdSupVda);

		itemPedido.setPerComisSup(perComisSup);
		itemPedido.setCdVendedor(cdVendedor);
		itemPedido.setPerComisVen(perComisVen);
		itemPedido.setDcTextoNf1(dcTextoNf1);
		itemPedido.setDcTextoNf2(dcTextoNf2);

		itemPedido.setDcTextoNf3(dcTextoNf3);
		itemPedido.setDcTextoNf4(dcTextoNf4);
		itemPedido.setDcTextoCar1(dcTextoCar1);
		itemPedido.setDcTextoCar2(dcTextoCar2);
		itemPedido.setDcTextoCar3(dcTextoCar3);

		itemPedido.setDcTextoCar4(dcTextoCar4);
		itemPedido.setDcTextoTra1(dcTextoTra1);
		itemPedido.setDcTextoTra2(dcTextoTra2);
		itemPedido.setDcTextoTra3(dcTextoTra3);
		itemPedido.setDcTextoTra4(dcTextoTra4);
		
		itemPedido.setDcTextoCom1(dcTextoCom1);
		itemPedido.setDcTextoCom2(dcTextoCom2);
		itemPedido.setDcTextoCom3(dcTextoCom3);
		itemPedido.setDcTextoCom4(dcTextoCom4);
		itemPedido.setNrOrdVenda(nrOrdVenda);
		itemPedido.setTpEmb(tpEmb);
		itemPedido.setDtFixa(dtFixa);
		itemPedido.setCdVenEstat(cdVenEstat);
		
		return itemPedido;
	}	
}

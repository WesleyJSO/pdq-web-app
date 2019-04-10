package com.pdq.pedido.business.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.dao.impl.PedidoItemDAO;
import com.pdq.pedido.dao.impl.StatusPedidoDAO;
import com.pdq.pedido.domain.Campanha;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.util.PDFUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@SuppressWarnings("deprecation")
public class SendEmailsToManagers implements IStrategy<PedidoHelper> {
	
	final static Logger LOG = LoggerFactory.getLogger(SendEmailsToManagers.class);
	
	@Autowired
	private StatusPedidoDAO statusPedidoDAO;
	
	@Autowired
	private PedidoItemDAO pedidoItemDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if (aEntity != null && aEntity.getId() != null) {
			Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
			Pedido pedido = optionalPedido.isPresent() ? optionalPedido.get() : null;
			List<PedidoItem> listPedidoItens = pedido.getListPedidoItem();
			if (!CollectionUtils.isEmpty(listPedidoItens)) {
				sendEmails(pedido, listPedidoItens);
			} else {
				error(aCase, "Não foram encontrados itens no pedido.", true);
			}
			return;
		}
		error(aCase, "Entidade Pedido não encontrada.", true);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void sendEmails(Pedido pedido, List<PedidoItem> listPedidoItens) {

		boolean sendEmail = false;
		Stream<StatusPedido> streamStatusAprovacao = statusPedidoDAO.findAllStatusAprovacao();

		// flag if approval status
		streamStatusAprovacao.forEach(status -> {
			if (status.getId().equals(pedido.getStatusPedido().getId())) {
				sendEmail = true;
			}
		});

		if (!sendEmail) {
			return;
		}

		LOG.info("Enviando email do pedido :" + pedido.getCodSap());

		JasperPrint jasperPrint = PDFUtils.generateApproverPDF(pedido, listPedidoItens);

		// generate PDF file
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		try {
			exporter.exportReport();
		} catch (JRException e) {
			LOG.error(e.getMessage(), e);
		}

		List<Long> lstIdLinhaProduto = null;
		if (listPedidoItens != null) {
			listPedidoItens.forEach(pi -> {
				lstIdLinhaProduto.add(pi.getProdutoPrecoRegras().getLinhaProduto().getId());
			});
		}
		List<Integer> lstIdPerfil = null;
		Set<String> lstEmail = new HashSet<String>();
		if (pedido.getStatusPedido() != null) {
			lstIdPerfil = pedidoDAO.retornaIdPerfilUsuarioAprovador(pedido.getStatusPedido().getId());
			if (lstIdPerfil != null && !lstIdPerfil.isEmpty()) {
				for (Integer idPerfil : lstIdPerfil) {
					if (idPerfil != null) {
						List<String> lstTemp = pedidoDAO.retornaEmailUsuarioAprovador(idPerfil.longValue(),
								pedido.getRegional().getIdRegional(), lstIdLinhaProduto);
						if (lstTemp != null && !lstTemp.isEmpty()) {
							lstEmail.addAll(lstTemp);
						}
					}
				}
			}

			// início jira S3P-928
			String tipo = pedido.getOrcamento() ? "Orçamento" : "Pedido";
			String agente = pedido.getVendaAgenciada()
					? "\nAgente: " + pedido.getVendedorAgenciado().getNomVendedorSap() : "";

			String campanhas = "";
			if (pedido.getCampanha()) {
				for (Campanha c : pedido.getLstCampanhas()) {
					campanhas += c.getNomeCampanha() + ", ";
				}
				campanhas = "\nCampanha(s): " + campanhas.substring(0, campanhas.length() - 2);
			}

			String fabricas = "";
			for (PedidoItem pi : getListaPedidoItem(pedido.getId())) {
				fabricas += pi.getProdutoPrecoRegras().getProduto().getDesProduto() + " - "
						+ pi.getFabrica().getDesFabrica() + "\n";
			}

			String corpoEmail = "\n" + tipo + " de número " + pedido.getCodSap() + " está aguardando sua aprovação!"
					+ "\nRTV: " + pedido.getUsuarioRtv().getLogin() + agente + "\nNome do cliente: "
					+ pedido.getCliente().getNomCliente() + "\nClassificação do cliente: "
					+ pedido.getClassificacaoCliente().getDesClassificacaoCliente() + "\nCidade do cliente: "
					+ pedido.getCliente().getEndereco().getCidade().getNomCidade() + "\nNome da regional: "
					+ pedido.getRegional().getNomRegional() + campanhas + "\n\nFabricas:\n" + fabricas;
			// fim jira S3P-928

			// se achou e-mail, faz loop para enviar aqui
			if (!lstEmail.isEmpty()) {
				LOG.info("Enviando email do pedido para os emails :" + lstEmail);
				for (String email : lstEmail) {
					/**
					 * Gustavo - 29/08/2014 - Vefifica se é pedido ou orçamento
					 */
					mailService.sendPDF(null, email, "Aprovação", corpoEmail, "Aprovação.pdf", baos.toByteArray());
				}
			}
		}

		LOG.info("Pedido para os emails :" + lstEmail + " enfileirados com sucesso!");

	}

	private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}
}

package com.s3.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.Pedido;
import com.s3.helper.PedidoHelper;
import com.s3.repository.PedidoRepository;
/**
 * <p><b>Verify if order is not null and if has any items</b></p>
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 23-04-2019 13:33:56
 */
@Component
public class ValidDataToSendEmail implements IStrategy<PedidoHelper> {
		
	@Autowired private PedidoRepository pedidoRepository;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		
		if (aEntity != null && aEntity.getId() != null) {
			
			if (CollectionUtils.isEmpty(aEntity.getListPedidoItem())) {
				Optional<Pedido> optionalPedido = pedidoRepository.findById(aEntity.getId());
				if(optionalPedido.isPresent())
					aEntity.setListPedidoItem(optionalPedido.get().getListPedidoItem());
				
				if (CollectionUtils.isEmpty(aEntity.getListPedidoItem())) {
					aCase.getResult().setMessage("Não foram encontrados itens no pedido.");
					aCase.getResult().setError();
					aCase.suspendExecution();
				}
			}
			aCase.getResult().addEntity(aEntity);
			return;
		}
		aCase.getResult().setMessage("Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}


/*@Transactional(propagation = Propagation.SUPPORTS)
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
	String fabricas = "";
	if (listPedidoItens != null) {
		listPedidoItens.forEach(pi -> {
			lstIdLinhaProduto.add(pi.getProdutoPrecoRegras().getLinhaProduto().getId());
			fabricas += pi.getProdutoPrecoRegras().getProduto().getDesProduto() + " - "
					+ pi.getFabrica().getDesFabrica() + "\n";
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
							pedido.getRegional().getId(), lstIdLinhaProduto);
					if (lstTemp != null && !lstTemp.isEmpty()) {
						lstEmail.addAll(lstTemp);
					}
				}
			}
		}

		// início jira S3P-928
		String tipo = pedido.getOrcamento() ? "Orçamento" : "Pedido";
		String agente = pedido.getVendaAgenciada()
				? "\nAgente: " + pedido.getVendedorAgenciado().getNomeVendedorSap() : "";

		String campanhas = "";
		if (pedido.getCampanha()) {
			for (Campanha c : pedido.getLstCampanhas()) {
				campanhas += c.getNomeCampanha() + ", ";
			}
			campanhas = "\nCampanha(s): " + campanhas.substring(0, campanhas.length() - 2);
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
				mailService.sendPDF(null, email, "Aprovação", corpoEmail, "Aprovação.pdf", baos.toByteArray());
			}
		}
	}

	LOG.info("Pedido para os emails :" + lstEmail + " enfileirados com sucesso!");

}

private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
	
	if (suspend)
		aCase.suspendExecution();
}*/

package com.s3.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Funcionario;
import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.Perfil;
import com.pdq.pedido.domain.Regra;
import com.s3.dao.impl.ControleAprovacaoDAO;
import com.s3.dao.impl.FuncionarioDAO;
import com.s3.dao.impl.PedidoDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusPedidoHelper;
import com.s3.service.email.MailService;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 23-04-2019 13:40:22
 *
 */
@Component
public class SendEmailPedido implements IStrategy<PedidoHelper> {

	// StatusPedido.ID_STATUS_NAO_APROVADO) || pedido.getStatusPedido().getId().equals(StatusPedido.ID_STATUS_CANCELADO enviarEmailPedidoNaoAprovado
	@Autowired private MailService mailService;
	@Autowired private PedidoDAO pedidoDAO;
	@Autowired private FuncionarioDAO funcionarioDAO;
	@Autowired private ControleAprovacaoDAO controleAprovacaoDAO;
	
	private StringBuilder campaign;
	private StringBuilder factories;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {

		if (aEntity != null && aEntity.getStatusPedido() != null
				&& StatusPedidoHelper.contains(StatusPedidoHelper.IDS_STATUS_APROVACAO, aEntity.getStatusPedido())) {
			
			Optional<Pedido> pedido = aCase.getResult().getEntity();
			if(pedido.isPresent())
				aEntity = (PedidoHelper) pedido.get(); // Can I do this? maybe I'm losing data from aEntity here! Need to check!
			
			List<ControleAprovacao> listControleAprovacao = controleAprovacaoDAO.findByIdPedido(aEntity.getId());
			
			List<Regra> listRegra = new ArrayList<>();
			listControleAprovacao.forEach(element -> listRegra.add(element.getRegra()));
			List<Perfil> listPerfil = new ArrayList<>();
			listRegra.forEach(element -> listPerfil.add(element.getPerfil()));
			List<LinhaProduto> listLinhaProduto = new ArrayList<>();
			aEntity.getListPedidoItem().forEach(element -> listLinhaProduto.add(element.getProdutoPrecoRegras().getLinhaProduto()));
			List<String> listEmail = pedidoDAO.findApproverUserEmail(listPerfil, aEntity.getRegional(), listLinhaProduto);

            String orderType = aEntity.getOrcamento() ? "Orçamento" : "Pedido";
            String agente = aEntity.getVendaAgenciada() ? "\nAgente: " + aEntity.getVendedorAgenciado().getNomeVendedorSap() : "";
            campaign = new StringBuilder();
            if(aEntity.getCampanha()) {
            	aEntity.getLstCampanhas().forEach(element -> campaign.append(element.getNomeCampanha().concat(", ")));
            	campaign = new StringBuilder("\nCampanha(s): ".concat(campaign.toString().substring(0, campaign.toString().length() -2)));
            }
            factories = new StringBuilder();
            aEntity.getListPedidoItem().forEach(element -> factories.append(element.getProdutoPrecoRegras()
            		.getProduto().getDesProduto().concat(element.getFabrica().getDesFabrica())));
            
            factories = new StringBuilder(factories.substring(0, factories.toString().length() -2));
            
            String emailBody = "\n"
            		.concat(orderType)
            		.concat(" de número ")
            		.concat(aEntity.getCodSap())
            		.concat(" está aguardando sua aprovação!")
            		.concat("\nRTV: ")
            		.concat(funcionarioDAO.findById(aEntity.getUsuarioRtv().getId(), new Funcionario()).get().getNomFuncionario())
            		.concat(agente)
            		.concat("\nNome do cliente: ")
            		.concat(aEntity.getCliente().getNomCliente())
            		.concat("\nClassificação do cliente: ")
            		.concat(aEntity.getClassificacaoCliente().getDesClassificacaoCliente())
            		.concat("\nCidade do cliente: ")
            		.concat(aEntity.getCliente().getEndereco().getCidade().getNomCidade())
        			.concat("\nNome da regional: ")
        			.concat(aEntity.getRegional().getNomRegional())
        			.concat(campaign.toString()) 
        			.concat("\n\nFabricas:\n")
        			.concat(factories.toString());
            
            if(!CollectionUtils.isEmpty(listEmail))
            	listEmail.forEach(element -> {
            		mailService.sendWithAttachment(element, "Aprovação",
            				emailBody, "Aprovação PDF", 
            				fileContent ? fileContent.toByteArray() : null);
            	});

            
            /*
			if(pedido.isPresent() && pedido.get().getStatusPedido() != null) {
				List<Integer> listId = pedidoDAO.
				StatusPedido statusPedido = pedido.get().getStatusPedido();
				List<String> listEmail = pedidoDAO.findApproverUserEmail();
			}
			mailService.send(to, subject, text)
			return;*/
		}
		aCase.getResult().setMessage("Pedido não encontrada.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}





















































































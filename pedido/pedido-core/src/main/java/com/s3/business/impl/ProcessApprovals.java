package com.s3.business.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.ControleAprovacaoPedidoItem;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.RegraAprovacaoPrazo;
import com.pdq.pedido.domain.Usuario;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.ControleAprovacaoHelper;
import com.s3.helper.StatusControleAprovacaoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 15 de abr de 2019
 *
 */
@Component
public class ProcessApprovals implements IStrategy<ControleAprovacaoHelper> {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void process(ControleAprovacaoHelper aEntity, INavigationCase<ControleAprovacaoHelper> aCase) {
		Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.get();
		Optional<Stream<ControleAprovacao>> optional = aCase.getResult().getEntities();
		List<ControleAprovacao> listControleAprovacao = optional.get().collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(listControleAprovacao)) {
			Optional<Stream<RegraAprovacaoPrazo>> regraAprovacaoPrazoOptional = aCase.getResult()
					.getEntity("findTermRulesResult");
			List<RegraAprovacaoPrazo> listRegra = regraAprovacaoPrazoOptional.get().collect(Collectors.toList());
			Usuario usuario = usuarioDAO.getLoggedUser();
			listControleAprovacao.forEach(controle -> {
				if (controle.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_APROVADO))
					controle.setApproved(true);
				else
					controle.setApproved(false);

				if (controle.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_REPROVADO))
					controle.setDisapproved(true);
				else
					controle.setDisapproved(false);

				if (controle.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_CANCELADO))
					controle.setCanceled(true);
				else
					controle.setCanceled(false);

				controle.setPermited(verifyPermission(pedido, controle, listRegra, usuario));
			});
			aCase.getResult().addEntities(listControleAprovacao.stream());
			return;
		}
		aCase.getResult().setMessage("As aprovações do pedido não foram encontradas.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}

	private Boolean verifyPermission(Pedido pedido, ControleAprovacao controle, List<RegraAprovacaoPrazo> listRegra,
			Usuario usuario) {
		if (controle.getRegra() instanceof RegraAprovacaoPrazo) {
			// Checks the status for each item. Only items not yet approved will go through the permission validation
			Boolean approved;
			for (PedidoItem item : pedido.getListPedidoItem()) {
				approved = false;
				for (ControleAprovacaoPedidoItem controleItem : item.getListControleAprovacaoPedidoItem()) {
					if (controleItem.isAtivo()
							&& controleItem.getStatusPedido().getId().equals(controle.getStatusPedido().getId())) {
						approved = true;
						break;
					}
				}
				if (!approved) {
					for (RegraAprovacaoPrazo regra : listRegra) {
						if (regra.getAprovador().getId().equals(usuario.getId()) && regra.getLstLinhaProduto()
								.contains(item.getProdutoPrecoRegras().getLinhaProduto())) {
							return true;
						}
					}
				}
			}
		} else {
			if (usuario.getListPerfil().contains(controle.getRegra().getPerfil())) {
				return true;
			}
		}
		return false;
	}

}

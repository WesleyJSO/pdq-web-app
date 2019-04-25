package com.s3.business.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.ControleAprovacaoPedidoItem;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.StatusControleAprovacao;
import com.pdq.pedido.domain.Usuario;
import com.s3.dao.impl.RegraDAO;
import com.s3.dao.impl.StatusControleAprovacaoDAO;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusControleAprovacaoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 25 de abr de 2019
 *
 */
@Component
public class ChangeStatusControle implements IStrategy<PedidoHelper> {

	@Autowired
	private StatusControleAprovacaoDAO statusControleAprovacaoDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	RegraDAO regraDAO;

	StatusControleAprovacao approved;
	StatusControleAprovacao disapproved;
	StatusControleAprovacao canceled;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.get();
		List<ControleAprovacao> listControleAprovacao = aEntity.getListControleAprovacao();
		if (!CollectionUtils.isEmpty(listControleAprovacao)) {
			Usuario usuario = usuarioDAO.getLoggedUser();
			findStatuses();
			listControleAprovacao.forEach(ca -> {
				ca.setPedido(pedido);
				if (StatusControleAprovacaoHelper.ID_PENDENTE.equals(ca.getStatusControleAprovacao().getId())) {
					if (ca.getDisapproved())
						ca.setStatusControleAprovacao(disapproved);
					else if (ca.getCanceled())
						ca.setStatusControleAprovacao(canceled);
					else if (ca.getApproved()) {
						// check if every item has been approved for this status
						Boolean approve = false;
						for (PedidoItem item : pedido.getListPedidoItem()) {
							approve = false;
							for (ControleAprovacaoPedidoItem controleItem : item.getListControleAprovacaoPedidoItem()) {
								if (controleItem.isAtivo() && controleItem.getStatusPedido().getId()
										.equals(ca.getStatusPedido().getId())) {
									approve = true;
									break;
								}
							}
							if (!approve)
								break;
						}

						if (approve)
							ca.setStatusControleAprovacao(approved);
					}
					if (!StatusControleAprovacaoHelper.ID_PENDENTE.equals(ca.getStatusControleAprovacao().getId())) {
						ca.setDataAprovacao(LocalDate.now());
						ca.setUsuario(usuario);
					}
				}
			});
			pedido.setListControleAprovacao(listControleAprovacao);
			aCase.getResult().addEntities(listControleAprovacao.stream());
		} else {
			error(aCase, "Não foi possível encontrar a lista de aprovações do pedido", true);
		}
		return;
	}

	private void findStatuses() {
		approved = statusControleAprovacaoDAO.findById(StatusControleAprovacaoHelper.ID_APROVADO);
		disapproved = statusControleAprovacaoDAO.findById(StatusControleAprovacaoHelper.ID_REPROVADO);
		canceled = statusControleAprovacaoDAO.findById(StatusControleAprovacaoHelper.ID_CANCELADO);
	}

	private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}

}

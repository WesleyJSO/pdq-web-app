package com.s3.business.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.StatusControleAprovacao;
import com.pdq.pedido.domain.Usuario;
import com.s3.dao.impl.ControleAprovacaoDAO;
import com.s3.dao.impl.StatusControleAprovacaoDAO;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusControleAprovacaoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 11 de abr de 2019
 *
 */
@Component
public class ChangeStatusControleAprovacao implements IStrategy<PedidoHelper> {

	@Autowired
	private StatusControleAprovacaoDAO statusControleAprovacaoDAO;

	@Autowired
	private ControleAprovacaoDAO controleAprovacaoDao;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

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
			List<ControleAprovacao> listApproved = new ArrayList<>();
			listControleAprovacao.forEach(ca -> {
				ca.setPedido(pedido);
				if (StatusControleAprovacaoHelper.ID_PENDENTE.equals(ca.getStatusControleAprovacao().getId())) {
					if (ca.getDisapproved())
						ca.setStatusControleAprovacao(disapproved);
					else if (ca.getCanceled())
						ca.setStatusControleAprovacao(canceled);
					else if (ca.getApproved()) {
						ca.setStatusControleAprovacao(approved);
						listApproved.add(ca);
					}
					if (!StatusControleAprovacaoHelper.ID_PENDENTE.equals(ca.getStatusControleAprovacao().getId())){
						ca.setDataAprovacao(LocalDate.now());
						ca.setUsuario(usuario);
					}
				}
			});
			controleAprovacaoDao.saveAll(listControleAprovacao);
			aCase.getResult().addEntities(listControleAprovacao.stream());
			aCase.getResult().addEntity("changeStatusControleAprovacaoResult", listApproved.stream());
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

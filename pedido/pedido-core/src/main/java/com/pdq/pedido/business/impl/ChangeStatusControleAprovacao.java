package com.pdq.pedido.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.dao.impl.ControleAprovacaoDAO;
import com.pdq.pedido.dao.impl.StatusControleAprovacaoDAO;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.StatusControleAprovacao;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.helper.StatusControleAprovacaoHelper;

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

	StatusControleAprovacao approved;
	StatusControleAprovacao disapproved;
	StatusControleAprovacao canceled;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.get();
		List<ControleAprovacao> listControleAprovacao = aEntity.getListControleAprovacao();
		if (!CollectionUtils.isEmpty(listControleAprovacao)) {
			findStatuses();
			List<ControleAprovacao> listApproved = new ArrayList<>();
			listControleAprovacao.forEach(ca -> {
				ca.setPedido(pedido);
				if (StatusControleAprovacaoHelper.ID_PENDENTE.equals(ca.getStatusControleAprovacao().getId()))
					if (ca.getDisapproved())
						ca.setStatusControleAprovacao(disapproved);
					else if (ca.getCanceled())
						ca.setStatusControleAprovacao(canceled);
					else if (ca.getApproved()) {
						ca.setStatusControleAprovacao(approved);
						listApproved.add(ca);
					} 
			});
			controleAprovacaoDao.saveAll(listControleAprovacao);
			aCase.getResult().addEntities(listControleAprovacao.stream());
			aCase.getResult().addEntity("approvedList", listApproved.stream());
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

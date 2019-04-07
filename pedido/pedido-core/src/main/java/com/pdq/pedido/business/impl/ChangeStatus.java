package com.pdq.pedido.business.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.dao.impl.PedidoDAO;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.helper.StatusControleAprovacaoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 7 de abr de 2019
 *
 */
public class ChangeStatus implements IStrategy<PedidoHelper> {

	@Autowired
	private PedidoDAO pedidoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if (aEntity != null && aEntity.getId() != null) {
			Pedido pedido = aEntity;
			List<ControleAprovacao> listControleAprovacao = aCase.getResult().getEntities();
			if (!CollectionUtils.isEmpty(listControleAprovacao)) {
				StatusPedido newStatus = findStatus(listControleAprovacao);
				if (null != newStatus) {
					pedido.setStatusPedido(newStatus);
					pedido.setDtAlteracaoAprovacao(new Date());
					pedidoDAO.save(aEntity);
				} else {
					error(aCase, "Não há status pendentes.", true);
				}
			} else {
				error(aCase, "Não foi possível encontrar a lista de aprovações do pedido", true);
			}
			return;
		}
		error(aCase, "Entidade Pedido não encontrada.", true);
	}

	private StatusPedido findStatus(List<ControleAprovacao> listControleAprovacao) {
		Stream<ControleAprovacao> stream = listControleAprovacao.stream();
		// get first pending active status
		return stream.filter(ca -> ca.isAtivo()
				&& ca.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_PENDENTE))
				.findFirst().orElse(null)
				.getStatusPedido();
	}

	private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}

}

package com.pdq.pedido.business.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
public class ChangeStatus implements IStrategy<PedidoHelper> {

	@Autowired
	private PedidoDAO pedidoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optionalPedido =  aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.isPresent() ? optionalPedido.get() : null;
		if (pedido != null && pedido.getId() != null) {
			Optional<Stream<ControleAprovacao>> optional = aCase.getResult().getEntities();
			List<ControleAprovacao> listControleAprovacao = optional.isPresent() ? optional.get().collect(Collectors.toList()) : null;
			if (!CollectionUtils.isEmpty(listControleAprovacao)) {
				aCase.getResult().addEntity("oldStatus", pedido.getStatusPedido());
				StatusPedido newStatus = findStatus(listControleAprovacao);
				if (null != newStatus) {
					pedido.setStatusPedido(newStatus);
					pedido.setDtAlteracaoAprovacao(new Date());
					pedidoDAO.save(pedido);
					aCase.getResult().addEntities(listControleAprovacao.stream());
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

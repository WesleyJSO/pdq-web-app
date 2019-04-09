package com.pdq.pedido.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.dao.impl.HistStatusPedidoDAO;
import com.pdq.pedido.dao.impl.StatusPedidoDAO;
import com.pdq.pedido.dao.impl.UsuarioDAO;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.HistStatusPedido;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.pedido.domain.Usuario;
import com.pdq.pedido.helper.PedidoHelper;
import com.pdq.pedido.helper.StatusPedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 7 de abr de 2019
 *
 */
@Component
public class GenerateStatusHistory implements IStrategy<PedidoHelper> {

	@Autowired
	StatusPedidoDAO statusPedidoDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	HistStatusPedidoDAO histStatusPedidoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		if (aEntity != null && aEntity.getId() != null) {
			Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
			Pedido pedido = optionalPedido.isPresent() ? optionalPedido.get() : null;
			Optional<Stream<ControleAprovacao>> optional = aCase.getResult().getEntities();
			Stream<ControleAprovacao> streamControleAprovacao = optional.isPresent() ? optional.get() : null;
			Optional<StatusPedido> statusOptional = aCase.getResult().getEntity("oldStatus");
			StatusPedido oldStatus = statusOptional.isPresent() ? statusOptional.get() : null;
			StatusPedido newStatus = pedido.getStatusPedido();
			if (null != oldStatus) {
				List<StatusPedido> listApprovedStatus = findApprovedStatuses(streamControleAprovacao, oldStatus, newStatus);
				List<HistStatusPedido> listHistStatusPedido = generate(listApprovedStatus, pedido, oldStatus,
						newStatus, aEntity.getObservacaoHistorico());
				histStatusPedidoDAO.saveAll(listHistStatusPedido);
			} else {
				error(aCase, "Erro na geração de histórico de aprovação.", true);
			}
			return;
		}
		error(aCase, "Entidade Pedido não encontrada.", true);
	}
	
	private List<StatusPedido> findApprovedStatuses(Stream<ControleAprovacao> streamControleAprovacao,
			StatusPedido oldStatus, StatusPedido newStatus) {
		// get approved statuses by order bigger than old status and smaller than new status
		List<ControleAprovacao> listApprovedControleAprovacao = streamControleAprovacao
				.filter(ca -> ca.getStatusPedido().getOrdem() >= oldStatus.getOrdem() && ca.getStatusPedido().getOrdem() < newStatus.getOrdem())
				.collect(Collectors.toList());
		List<StatusPedido> listApprovedStatus = new ArrayList<>();
		// adds old status to list if it is initial status
		if (StatusPedidoHelper.ID_STATUS_EM_CONSTRUCAO.equals(oldStatus.getId()))
			listApprovedStatus.add(oldStatus);
		listApprovedControleAprovacao.forEach(ca -> listApprovedStatus.add(ca.getStatusPedido()));
		return listApprovedStatus;
	}

	private List<HistStatusPedido> generate(List<StatusPedido> listApprovedStatus, Pedido pedido,
			StatusPedido oldStatus, StatusPedido newStatus, String obs) {		
		List<HistStatusPedido> listHistStatusPedido = new ArrayList<>();
		Usuario usuario = usuarioDAO.getLoggedUser();
		listApprovedStatus
				.forEach(status -> listHistStatusPedido.add(new HistStatusPedido(status, usuario, pedido, obs)));
		return listHistStatusPedido;
	}

	private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}

}

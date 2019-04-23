package com.s3.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.HistStatusPedido;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.pedido.domain.Usuario;
import com.s3.dao.impl.HistStatusPedidoDAO;
import com.s3.dao.impl.UsuarioDAO;
import com.s3.helper.PedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 7 de abr de 2019
 *
 */
@Component
public class GenerateStatusHistory implements IStrategy<PedidoHelper> {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private HistStatusPedidoDAO histStatusPedidoDAO;

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.get();
		Optional<Stream<ControleAprovacao>> controleAprovacaoOptional = aCase.getResult().getEntity("changeStatusControleAprovacaoResult");
		Stream<ControleAprovacao> streamApproved = controleAprovacaoOptional.isPresent() ? controleAprovacaoOptional.get() : Stream.empty();
		Optional<StatusPedido> statusOptional = aCase.getResult().getEntity("changeStatusPedidoResult");
		StatusPedido oldStatus = statusOptional.get();
		StatusPedido newStatus = pedido.getStatusPedido();
		List<StatusPedido> listApprovedStatus = findApprovedStatuses(streamApproved, oldStatus, newStatus);
		List<HistStatusPedido> listHistStatusPedido = generate(listApprovedStatus, pedido,
				aEntity.getObservacaoHistorico());
		
		histStatusPedidoDAO.saveAll(listHistStatusPedido);
	}

	// obtains the approved statuses, except the old one, for the history should show the destination statuses of the order/budget
	private List<StatusPedido> findApprovedStatuses(Stream<ControleAprovacao> streamControleAprovacao,
			StatusPedido oldStatus, StatusPedido newStatus) {
		List<StatusPedido> listApprovedStatus = new ArrayList<>();
		List<ControleAprovacao> listApprovedControleAprovacao = streamControleAprovacao.collect(Collectors.toList());
		listApprovedControleAprovacao.forEach(ca -> listApprovedStatus.add(ca.getStatusPedido()));
		listApprovedStatus.add(newStatus);
		listApprovedStatus.remove(oldStatus);
		return listApprovedStatus;
	}

	private List<HistStatusPedido> generate(List<StatusPedido> listApprovedStatus, Pedido pedido, String obs) {
		List<HistStatusPedido> listHistStatusPedido = new ArrayList<>();
		Usuario usuario = usuarioDAO.getLoggedUser();
		listApprovedStatus
				.forEach(status -> listHistStatusPedido.add(new HistStatusPedido(status, usuario, pedido, obs)));
		return listHistStatusPedido;
	}

}

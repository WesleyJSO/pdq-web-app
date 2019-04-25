package com.s3.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.ControleAprovacaoPedidoItem;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.StatusPedido;
import com.s3.dao.impl.StatusPedidoDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusPedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 24 de abr de 2019
 *
 */
@Component
public class ChangePedidoItemStatus implements IStrategy<PedidoHelper> {

	@Autowired
	private StatusPedidoDAO statusPedidoDAO;
	private StatusPedido finalStatusAprovacao;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optional = aCase.getResult().getEntity();
		Pedido pedido = optional.get();
		Optional<Stream<ControleAprovacao>> controleAprovacaoOptional = aCase.getResult().getEntities();
		List<ControleAprovacao> listControleAprovacao = controleAprovacaoOptional.get().collect(Collectors.toList());
		finalStatusAprovacao = findFinalStatus(pedido);

		Map<String, List<StatusPedido>> mapStatusApproved = initMap(pedido);
		
		StatusPedido newStatus;
		for (PedidoItem item : pedido.getListPedidoItem()) {
			newStatus = findStatus(item, mapStatusApproved, listControleAprovacao);
			item.setStatusAprovacao(newStatus);			
		}
		aCase.getResult().addEntities(listControleAprovacao.stream());
	}
	
	/**
	 * @return the first not approved status for the given item
	 */
	private StatusPedido findStatus(PedidoItem item, Map<String, List<StatusPedido>> map, List<ControleAprovacao> listControleAprovacao) {
		List<StatusPedido> listApprovedStatus = map.get(item.getId());
		ControleAprovacao controleAprovacao = listControleAprovacao.stream()
				.filter(ca -> ca.isAtivo()
						&& !listApprovedStatus.contains(ca.getStatusPedido()))
				.findFirst().orElse(null);
		return controleAprovacao != null ? controleAprovacao.getStatusPedido() : finalStatusAprovacao;
	}
	
	private StatusPedido findFinalStatus(Pedido pedido) {
		return pedido.getOrcamento()
				? statusPedidoDAO.findById(StatusPedidoHelper.ID_STATUS_APROVADO, pedido.getStatusPedido()).get()
				: statusPedidoDAO.findById(StatusPedidoHelper.ID_STATUS_IMPLANTADO, pedido.getStatusPedido()).get();
	}
	

	private Map<String, List<StatusPedido>> initMap(Pedido pedido) {
		List<PedidoItem> listPedidoItem = pedido.getListPedidoItem();
		Map<String, List<StatusPedido>> mapStatusApproved = new HashMap<>();
		List<StatusPedido> listApproved;
		for (PedidoItem item : listPedidoItem) {
			listApproved = new ArrayList<>();
			for (ControleAprovacaoPedidoItem controlePedidoItem : item.getListControleAprovacaoPedidoItem()) {
				if (controlePedidoItem.isAtivo()){
					listApproved.add(controlePedidoItem.getStatusPedido());
				}			
			}			
			mapStatusApproved.put(item.getId(), listApproved);
		}
		return mapStatusApproved;
	}

}

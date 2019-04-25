package com.s3.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.Pedido;
import com.s3.dao.impl.RegraDAO;
import com.s3.helper.PedidoHelper;
import com.s3.helper.RegraHelper;
import com.s3.helper.StatusControleAprovacaoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 23 de abr de 2019
 *
 */
@Component
public class FilterApproved implements IStrategy<PedidoHelper> {

	@Autowired
	RegraDAO regraDAO;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Optional<Pedido> optionalPedido = aCase.getResult().getEntity();
		Pedido pedido = optionalPedido.get();
		List<ControleAprovacao> listControleAprovacao = aEntity.getListControleAprovacao();
		Filter<RegraHelper> filterRegra = new Filter<>();
		RegraHelper regraHelper = new RegraHelper();
		filterRegra.setEntity(regraHelper);
		if (!CollectionUtils.isEmpty(listControleAprovacao)) {
			List<ControleAprovacao> listApproved = new ArrayList<>();
			listControleAprovacao.forEach(ca -> {
				ca.setPedido(pedido);
				regraHelper.setId(ca.getRegra().getId());
				ca.setRegra(regraDAO.findRegraById(filterRegra));
				if (StatusControleAprovacaoHelper.ID_PENDENTE.equals(ca.getStatusControleAprovacao().getId())) {
					if (ca.getApproved()) {
						listApproved.add(ca);
					}
				}
			});
			aCase.getResult().addEntities(listControleAprovacao.stream());
			aCase.getResult().addEntity("changeStatusControleAprovacaoResult", listApproved.stream());
		} else {
			error(aCase, "Não foi possível encontrar a lista de aprovações do pedido", true);
		}
		return;
	}

	private void error(INavigationCase<PedidoHelper> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}

}


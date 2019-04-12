package com.s3.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.domain.StatusControleAprovacao;
import com.s3.dao.impl.ControleAprovacaoDAO;
import com.s3.dao.impl.StatusControleAprovacaoDAO;
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

	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		List<ControleAprovacao> listControleAprovacao = aEntity.getListControleAprovacao();
		if (!CollectionUtils.isEmpty(listControleAprovacao)) {
			StatusControleAprovacao approved = statusControleAprovacaoDAO
					.findById(StatusControleAprovacaoHelper.ID_APROVADO);
			StatusControleAprovacao disapproved = statusControleAprovacaoDAO
					.findById(StatusControleAprovacaoHelper.ID_REPROVADO);
			listControleAprovacao.forEach(ca -> {
				if (ca.getApproved())
					ca.setStatusControleAprovacao(approved);
				else if (ca.getDisapproved())
					ca.setStatusControleAprovacao(disapproved);
			});
			controleAprovacaoDao.saveAll(listControleAprovacao);
			aCase.getResult().addEntities(listControleAprovacao.stream());
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

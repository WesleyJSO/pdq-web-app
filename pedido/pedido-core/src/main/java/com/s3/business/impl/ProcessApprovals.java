package com.pdq.pedido.business.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.pedido.helper.ControleAprovacaoHelper;
import com.pdq.pedido.helper.StatusControleAprovacaoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 15 de abr de 2019
 *
 */
@Component
public class ProcessApprovals implements IStrategy<ControleAprovacaoHelper> {

	@Override
	public void process(ControleAprovacaoHelper aEntity, INavigationCase<ControleAprovacaoHelper> aCase) {
		Optional<Stream<ControleAprovacao>> optional = aCase.getResult().getEntities();
		List<ControleAprovacao> listControleAprovacao = optional.get().collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(listControleAprovacao)) {
			listControleAprovacao.forEach(controle -> {
				if (controle.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_APROVADO))
					controle.setApproved(true);
				else
					controle.setApproved(false);
				
				if (controle.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_REPROVADO))
					controle.setDisapproved(true);
				else
					controle.setDisapproved(false);
				
				if (controle.getStatusControleAprovacao().getId().equals(StatusControleAprovacaoHelper.ID_CANCELADO))
					controle.setCanceled(true);
				else
					controle.setCanceled(false);
			});
			aCase.getResult().addEntities(listControleAprovacao.stream());
			return;
		}
		aCase.getResult().setMessage("As aprovações do pedido não foram encontradas.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}

}

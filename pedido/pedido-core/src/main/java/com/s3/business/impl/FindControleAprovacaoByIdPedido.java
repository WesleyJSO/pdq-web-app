package com.s3.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.google.common.base.Strings;
import com.pdq.pedido.domain.ControleAprovacao;
import com.s3.dao.impl.ControleAprovacaoDAO;
import com.s3.dao.impl.RegraDAO;
import com.s3.helper.ControleAprovacaoHelper;
import com.s3.helper.RegraHelper;

@Component
public class FindControleAprovacaoByIdPedido implements IStrategy<ControleAprovacaoHelper> {

	@Autowired
	ControleAprovacaoDAO controleAprovacaoDAO;
	
	@Autowired
	RegraDAO regraDAO;

	@Override
	public void process(ControleAprovacaoHelper aEntity, INavigationCase<ControleAprovacaoHelper> aCase) {
		if (aEntity != null && null != aEntity.getPedido()
				&& !Strings.isNullOrEmpty(((ControleAprovacaoHelper) aEntity).getPedido().getId())) {
			Filter<ControleAprovacaoHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			List<ControleAprovacao> listControleAprovacao = controleAprovacaoDAO.findControleAprovacaoByIdPedido(filter).collect(Collectors.toList());
			Filter<RegraHelper> filterRegra = new Filter<>();
			RegraHelper regraHelper = new RegraHelper();
			filterRegra.setEntity(regraHelper);
			listControleAprovacao.forEach(controle -> {
				regraHelper.setId(controle.getRegra().getId());
				controle.setRegra(regraDAO.findRegraById(filterRegra));
			});
			aCase.getResult().addEntities(listControleAprovacao.stream());
			return;
		}
		aCase.getResult().setMessage("Aprovações não encontradas.");
		aCase.getResult().setError();
		aCase.suspendExecution();
	}
}

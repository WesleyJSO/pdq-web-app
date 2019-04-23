package com.s3.business.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.ControleAprovacao;
import com.s3.dao.impl.ControleAprovacaoDAO;
import com.s3.helper.ControleAprovacaoHelper;
import com.s3.helper.PedidoHelper;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 23 de abr de 2019
 *
 */
@Component
public class InactivatePreviousApprovementList implements IStrategy<PedidoHelper> {

	@Autowired
	private ControleAprovacaoDAO dao;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		Filter<ControleAprovacaoHelper> filter = new Filter<>();
		ControleAprovacaoHelper helper = new ControleAprovacaoHelper();
		helper.setPedido(aEntity);
		filter.setEntity(helper);
		Stream<ControleAprovacao> streamControle = dao.findControleAprovacaoByIdPedido(filter);
		if(null != streamControle && streamControle.iterator().hasNext()) {
			List<ControleAprovacao> listaControle = streamControle.collect(Collectors.toList());
			listaControle.forEach(controle -> {
				controle.setAtivo(false);
			});
			dao.saveAll(listaControle);
		}
	}

}

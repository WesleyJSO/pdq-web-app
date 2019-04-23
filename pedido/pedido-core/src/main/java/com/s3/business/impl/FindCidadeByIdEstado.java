package com.s3.business.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Cidade;
import com.s3.dao.impl.CidadeDAO;
import com.s3.helper.CidadeHelper;

@Component
public class FindCidadeByIdEstado implements IStrategy<CidadeHelper> {
	
	@Autowired private CidadeDAO cidadeDAO;
	
	@Override
	public void process(CidadeHelper aEntity, INavigationCase<CidadeHelper> aCase) {
		if(aEntity != null && aEntity.getEstado() != null && aEntity.getEstado().getId() != null) {
			Filter<CidadeHelper> filter = new Filter<>();
			filter.setEntity(aEntity);
			Optional<Stream<Cidade>> listCidade = cidadeDAO.findByEstadoId(filter);
			if(listCidade.isPresent())
				aCase.getResult().addEntities(listCidade.get());
		}
	}
}

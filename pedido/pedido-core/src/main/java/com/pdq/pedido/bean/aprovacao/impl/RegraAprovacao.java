package com.pdq.pedido.bean.aprovacao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.bean.aprovacao.RegraAprovacaoValidator;
import com.pdq.pedido.dao.impl.RegraDAO;
import com.pdq.pedido.domain.Regra;
import com.pdq.pedido.helper.RegraHelper;

public abstract class RegraAprovacao implements RegraAprovacaoValidator {
	
	@Autowired private RegraDAO regraDao;
	
	@Override
	public Regra getRegra(String descricao){
		RegraHelper regraHelper = new RegraHelper();
		regraHelper.setDescricao(descricao);
		Filter<RegraHelper> filter = new Filter<>();
		filter.setEntity(regraHelper);
		List<Regra> listRegra = regraDao.findRegraByDescricao(filter).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(listRegra)){
			return listRegra.get(0);
		}
		return null;
	}

}

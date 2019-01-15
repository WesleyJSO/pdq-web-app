package com.pdq.pedido.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Cidade;

public interface ICidadeDAO {

	public Stream<Cidade> filter(Filter<Cidade> filter);
	
}

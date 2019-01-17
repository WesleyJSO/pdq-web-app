package com.pdq.regional.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.regional.domain.Cidade;

public interface ICidadeDAO {

	public Stream<Cidade> filter(Filter<Cidade> filter);
	
}

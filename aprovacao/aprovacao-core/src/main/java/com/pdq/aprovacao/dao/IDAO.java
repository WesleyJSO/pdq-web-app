package com.pdq.aprovacao.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.bce.domain.IEntity;

public interface IDAO<T extends IEntity> {

	public Stream<T> filter(Filter<T> filter);
}

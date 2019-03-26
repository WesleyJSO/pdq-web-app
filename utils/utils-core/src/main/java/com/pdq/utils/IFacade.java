package com.pdq.utils;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.domain.IEntity;
import com.dvsmedeiros.bce.domain.Result;

public interface IFacade<T extends IEntity, R extends Object> extends IEntity {

	Result save(T aEntity, INavigationCase<? extends IEntity> aCase);

	Result update(T aEntity, INavigationCase<? extends IEntity> aCase);

	Result delete(T aEntity, INavigationCase<? extends IEntity> aCase);

	Result findAll(Class<? extends T> clazz, INavigationCase<? extends IEntity> aCase);

	Result findById(R id, Class<? extends T> clazz, INavigationCase<? extends IEntity> aCase);

	Result find(T aFilter, INavigationCase<? extends IEntity> aCase);
	
}

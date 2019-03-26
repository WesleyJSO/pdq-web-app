package com.pdq.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.INavigator;
import com.dvsmedeiros.bce.core.controller.impl.BusinessCase;
import com.dvsmedeiros.bce.domain.IEntity;
import com.dvsmedeiros.bce.domain.Result;

@Component
@Transactional
public class AppFacade<T extends DomainEntity<R>, R extends Object> implements IFacade<T, R> {

	private static final String DAO = "DAO";
	
	@Autowired
	@Qualifier("navigator")
	private INavigator<T> navigator;

	@Autowired
	private Map<String, GenericDAO<T, R>> mapDAO;
	
	private Optional<GenericDAO<T, R>> getDAO(T clazz) {
		GenericDAO<T, R> genericDAO = null;
		Optional<GenericDAO<T, R>> optionalDAO = Optional.ofNullable(genericDAO);
		for(Entry<String, GenericDAO<T, R>> entry : mapDAO.entrySet()) {
			if(entry.getKey().toLowerCase()
					.equals(clazz
							.getClass()
							.getSimpleName()
							.concat(DAO)
							.toLowerCase())) {
				optionalDAO = Optional.of(entry.getValue());
				break;
			}
		}
			return optionalDAO;
	}
	
	
	@Override
	public Result save(T aEntity, INavigationCase<? extends IEntity> aCase) {
		
		navigator.run(aEntity, aCase);
		Optional<GenericDAO<T, R>> optionalDAO = getDAO(aEntity);
		if(!aCase.getResult().hasError() && !aCase.isSuspendExecution()) {
			if(optionalDAO.isPresent()) {
				Optional<T> saved = optionalDAO.get().save(aEntity);
				aCase.getResult().addEntity(saved.get());
			}
		}
		return aCase.getResult();
	}

	@Override
	public Result update(T aEntity, INavigationCase<? extends IEntity> aCase) {

		navigator.run(aEntity, aCase);
		Optional<GenericDAO<T, R>> optionalDAO = getDAO(aEntity);
		if(!aCase.getResult().hasError() && !aCase.isSuspendExecution()) {
			if(optionalDAO.isPresent()) {
				Optional<T> updated = optionalDAO.get().update(aEntity);
				aCase.getResult().addEntity(updated.get());
			}
		}
		return aCase.getResult();
	}

	@Override
	public Result delete(T aEntity, INavigationCase<? extends IEntity> aCase) {

		navigator.run(aEntity, aCase);
		Optional<GenericDAO<T, R>> optionalDAO = getDAO(aEntity);
		if(!aCase.getResult().hasError() && !aCase.isSuspendExecution() 
				&& aCase.getName().equals(BusinessCase.DEFAULT_CONTEXT_NAME)) {
			if(optionalDAO.isPresent()) {
				Optional<T> deleted = optionalDAO.get().delete(aEntity);
				aCase.getResult().addEntity(deleted.get());
			}
		}
		return aCase.getResult();
	}

	@Override
	public Result findAll(Class<? extends T> clazz, INavigationCase<? extends IEntity> aCase) {

		try {
			Optional<GenericDAO<T, R>> optionalDAO;
			optionalDAO = getDAO(clazz.newInstance());
			if(!aCase.getResult().hasError() && !aCase.isSuspendExecution() 
					&& aCase.getName().equals(BusinessCase.DEFAULT_CONTEXT_NAME)) {
				if(optionalDAO.isPresent()) {
					Optional<Stream<T>> found = optionalDAO.get()
							.findAll(clazz.newInstance());
					aCase.getResult().addEntities(found.get());
				}
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			// @FIXME - add logger
			e.printStackTrace();
		}
		return aCase.getResult();
	}

	@Override
	public Result find(T aFilter, INavigationCase<? extends IEntity> aCase) {
		
		navigator.run(aFilter, aCase);
		return aCase.getResult();
	}


	@Override
	public Result findById(R id, Class<? extends T> clazz, INavigationCase<? extends IEntity> aCase) {
		
		try {
			Optional<GenericDAO<T, R>> optionalDAO = getDAO(clazz.newInstance());
			if(optionalDAO.isPresent()) {
				Optional<T> found = optionalDAO.get().findById(id, clazz.newInstance());
				aCase.getResult().addEntity(found.get());
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			// @FIXME - add logger
			e.printStackTrace();
		}
		return aCase.getResult();
	}
}

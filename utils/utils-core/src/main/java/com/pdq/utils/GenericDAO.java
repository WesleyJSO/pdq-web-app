package com.pdq.utils;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 14:02:37
 *
 * @param <T>
 * @param <R>
 */
@Component
@Service
@Transactional
public abstract class GenericDAO<T extends DomainEntity<R>, R extends Object> implements IDAO<T> {

	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	protected IRepository<T, R> repository;

	@Override
	public T save(T aEntity) {
		return repository.save(aEntity);
	}
	
	@Override
	public Stream<T> saveAll(List<T> colection) {
		return repository.saveAll(colection).stream();
	}
	
	@Override
	public Stream<T> findAll() {
		return repository.findAll().stream();
	}
	
	@Override
	public T update(T aEntity) {
		return repository.save(aEntity);
	}

	@Override
	public T delete(T aEntity) {
		repository.delete(aEntity);
		return aEntity;
	}
}

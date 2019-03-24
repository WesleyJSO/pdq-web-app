package com.pdq.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 14:02:41
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public interface IDAO<T extends DomainEntity, R extends Object> {
	
	Optional<Stream<T>> saveAll(List<T> colection);

	Optional<Stream<T>> findAll(T entity);

	Optional<T> findById(R id, T clazz);
	
	Optional<T> save(T aEntity);
	
	Optional<T> update(T aEntity);

	Optional<T> delete(T aEntity);
}
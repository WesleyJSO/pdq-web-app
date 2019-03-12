package com.pdq.utils;

import java.util.List;
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
public interface IDAO<T extends DomainEntity> {
	
	T save(T aEntity);
	
	Stream<T> saveAll(List<T> colection);

	Stream<T> findAll();
	
	T update(T aEntity);

	T delete(T aEntity);
}

package com.pdq.utils;
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

	T update(T aEntity);

	T delete(T aEntity);	
}

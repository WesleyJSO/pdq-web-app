package com.pdq.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
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
public abstract class GenericDAO<T extends DomainEntity<R>, R extends Object> implements IDAO<T, R> {
	
	private static final String REPOSITORY ="Repository";
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	private Map<String, IRepository<T, R>> mapRepository;
	
	/**
	 * 
	 * @author José Wesley Silva
	 * 24-03-2019 12:29:59
	 * 
	 * Fetch the repository from a @Autowired map of repositories,
	 * the repository need to be name following 
	 * the pattern DomainEntityName with the string Repository in order to work.
	 * 
	 * @param clazz - the entity that is needed to fetch his repository
	 * @return the repository from the informed entity if any exists.
	 */
	private Optional<IRepository<T, R>> getRepository(T clazz) {
		IRepository<T, R> repository = null;
		Optional<IRepository<T, R>> optionalRepository = Optional.ofNullable(repository);
		for(Entry<String, IRepository<T, R>> entry : mapRepository.entrySet()) {
			if(entry.getKey().toLowerCase()
					.equals(clazz
							.getClass()
							.getSimpleName()
							.replace("helper", "")
							.concat(REPOSITORY)
							.toLowerCase())) {
				optionalRepository = Optional.of(entry.getValue());
				break;
			}	
		}
		return optionalRepository;
		
	}
	
	@Override
	public Optional<T> findById(R id, T clazz) {
		if(getRepository(clazz).isPresent())
			return getRepository(clazz).get().findById(id);
		return Optional.ofNullable(clazz);
	}
	
	@Override
	public Optional<Stream<T>> saveAll(List<T> collection) {
		Optional<Stream<T>> optionalStream = Optional.ofNullable(collection.stream());
		if(getRepository(collection.get(0)).isPresent())
			optionalStream = Optional
					.of(getRepository(collection.get(0))
							.get()
							.saveAll(collection)
							.stream());
		return optionalStream;
	}
	
	@Override
	public Optional<Stream<T>> findAll(T entity) {
		@SuppressWarnings("unchecked")		
		Optional<List<T>> listEntity = Optional.ofNullable((List<T>) em
				.createQuery("from ".concat(entity.getClass().getName()), entity.getClass())
				.getResultList());
		return Optional.ofNullable(listEntity.isPresent() ? listEntity.get().stream() : Stream.of(entity));
	}
	
	@Override
	public Optional<T> save(T aEntity) {
		Optional<IRepository<T, R>> repository = getRepository(aEntity);
		if(repository.isPresent())
			aEntity = repository.get().save(aEntity);
		return Optional.of(aEntity);
	}
	
	@Override
	public Optional<T> update(T aEntity) {
		return save(aEntity);
	}

	@Override
	public Optional<T> delete(T aEntity) {
		getRepository(aEntity).ifPresent(r -> r.delete(aEntity));
		return Optional.of(aEntity);
	}
}

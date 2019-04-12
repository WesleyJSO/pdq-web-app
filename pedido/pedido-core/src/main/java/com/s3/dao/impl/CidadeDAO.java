package com.s3.dao.impl;

import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Cidade;
import com.pdq.utils.GenericDAO;
import com.s3.repository.CidadeRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 07-03-2019 10:21:25
 *
 */
@Repository
@Transactional
public class CidadeDAO extends GenericDAO<Cidade, Long> {

	@Autowired private CidadeRepository cidadeRepository;

	public Optional<Stream<Cidade>> findByEstadoId(Filter<? extends Cidade> filter) {
		return Optional.ofNullable(cidadeRepository.findByEstadoId(filter.getEntity().getEstado().getId()).stream());		
	}
}

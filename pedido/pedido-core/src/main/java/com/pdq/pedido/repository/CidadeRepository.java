package com.pdq.pedido.repository;

import java.util.List;

import com.pdq.pedido.domain.Cidade;
import com.pdq.utils.IRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 26-03-2019 10:41:15
 *
 */
public interface CidadeRepository extends IRepository<Cidade, Long> {

	List<Cidade> findByEstadoId(Long id);
}

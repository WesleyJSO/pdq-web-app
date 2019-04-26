package com.s3.dao.impl;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.utils.GenericDAO;
import com.s3.repository.ControleAprovacaoRepository;

/**
 * @author Bruno Holanda
 * Muralis Acessoria e Tecnologia Ltda.
 * @date 8 de mar de 2019
 *
 */

@Repository
@Transactional
public class ControleAprovacaoDAO extends GenericDAO<ControleAprovacao, Long> {
	
	@Autowired private ControleAprovacaoRepository controleAprovacaoRepository;
	
	public Stream<ControleAprovacao> findControleAprovacaoByIdPedido(Filter<? extends ControleAprovacao> filter) {

		boolean validFilter = filter != null 
				&& filter.getEntity() != null 
				&& filter.getEntity().getPedido() != null
				&& filter.getEntity().getPedido().getId() != null;
		
		if(validFilter) {
			
			StringBuilder jpql = new StringBuilder();
			jpql.append("from ").append(ControleAprovacao.class.getName()).append(" ca ");
			jpql.append(" where ca.pedido.id = :id");
			return em.createQuery(jpql.toString(), ControleAprovacao.class)
				.setParameter("id", filter.getEntity().getPedido().getId())
				.getResultList().stream();
		}
		return null;
	}

	public List<ControleAprovacao> findByIdPedido(String id) {
		return controleAprovacaoRepository.findByIdPedido(id);
	}

}

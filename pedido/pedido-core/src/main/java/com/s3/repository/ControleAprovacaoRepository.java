package com.s3.repository;

import java.util.List;

import com.pdq.pedido.domain.ControleAprovacao;
import com.pdq.utils.IRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 23-04-2019 14:28:44
 *
 */
public interface ControleAprovacaoRepository extends IRepository<ControleAprovacao, Long> {

	List<ControleAprovacao> findByIdPedido(String id);

}

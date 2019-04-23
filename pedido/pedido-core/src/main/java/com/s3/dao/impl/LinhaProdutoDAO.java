package com.s3.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.utils.GenericDAO;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 07-03-2019 11:35:32
 *
 */
@Repository
@Transactional
public class LinhaProdutoDAO extends GenericDAO<LinhaProduto, Long> {

	
}

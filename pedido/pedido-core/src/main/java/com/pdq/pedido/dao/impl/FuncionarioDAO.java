package com.pdq.pedido.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.Funcionario;
import com.pdq.utils.GenericDAO;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 22-03-2019 16:01:24
 *
 */
@Repository
@Transactional
public class FuncionarioDAO extends GenericDAO<Funcionario, Long> {

}

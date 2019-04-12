package com.s3.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.FluxoPedido;
import com.pdq.utils.GenericDAO;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 26-03-2019 11:23:03
 *
 */
@Repository
@Transactional
public class EstadoDAO extends GenericDAO<FluxoPedido, Long> {
	
}

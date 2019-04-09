package com.pdq.pedido.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.HistStatusPedido;
import com.pdq.utils.GenericDAO;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 7 de abr de 2019
 *
 */
@Repository
@Transactional
public class HistStatusPedidoDAO extends GenericDAO<HistStatusPedido, Long> {
	
}

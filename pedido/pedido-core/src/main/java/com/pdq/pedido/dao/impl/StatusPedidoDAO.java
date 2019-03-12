package com.pdq.pedido.dao.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pdq.pedido.domain.StatusPedido;
import com.pdq.utils.GenericDAO;

@Repository
@Transactional
public class StatusPedidoDAO extends GenericDAO<StatusPedido, Long> { }

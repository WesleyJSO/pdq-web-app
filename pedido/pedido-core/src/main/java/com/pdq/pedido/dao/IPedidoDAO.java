package com.pdq.pedido.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.filter.PedidoHelper;

public interface IPedidoDAO {
	
	public Stream<Pedido> filter(Filter<PedidoHelper> filter);
}

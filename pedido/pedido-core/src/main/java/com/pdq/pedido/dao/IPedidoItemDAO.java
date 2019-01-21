package com.pdq.pedido.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.PedidoItem;

public interface IPedidoItemDAO {

	Stream<PedidoItem> findByIdPedido(Filter<PedidoItem> filter);
}

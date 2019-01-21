package com.pdq.pedido.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.TipoTabela;

public interface ITipoTabelaDAO {

	Stream<TipoTabela> findByIdPedido(Filter<PedidoItem> filter);
}

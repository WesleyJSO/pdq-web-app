package com.s3.repository;

import java.util.List;

import com.pdq.pedido.domain.PedidoItem;
import com.pdq.utils.IRepository;

public interface PedidoItemRepository extends IRepository<PedidoItem, String> {

	List<PedidoItem> findByPedidoId(String id);
}

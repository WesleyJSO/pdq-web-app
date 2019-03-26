package com.pdq.pedido.repository;

import com.pdq.pedido.domain.Pedido;
import com.pdq.utils.IRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 25-03-2019 16:57:58
 *
 */
public interface PedidoRepository extends IRepository<Pedido, String> {

	Pedido findByCodSap(String codSap);
}

package com.pdq.pedido.helper;

import com.pdq.pedido.domain.Cidade;
import com.pdq.pedido.domain.Estado;
import com.pdq.pedido.domain.Pedido;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 11:45:21
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PedidoHelper extends Pedido {

	private static final long serialVersionUID = -1435436907248085887L;
	
	private Estado estado;
	private Cidade cidade;
}

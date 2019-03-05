package com.pdq.pedido.helper;

import org.springframework.stereotype.Component;

import com.pdq.pedido.domain.Cidade;
import com.pdq.pedido.domain.Estado;
import com.pdq.pedido.domain.Pedido;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 11:45:21
 *
 */
@Getter
@Setter
@Component
public class PedidoHelper extends Pedido {

	private static final long serialVersionUID = -1435436907248085887L;
	
	private Estado estado;
	private Cidade cidade;
}

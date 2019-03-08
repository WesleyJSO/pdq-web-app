package com.pdq.pedido.helper;

import com.pdq.pedido.domain.CorPedido;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Bruno Holanda
 * Muralis Acessoria e Tecnologia Ltda.
 * @date 8 de mar de 2019
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class CorPedidoHelper extends CorPedido {

	private static final long serialVersionUID = 5818882669327434960L;
	
	public static final Long ID_AZUL = 1L;
	public static final Long ID_VERDE = 3L;
	public static final Long ID_AMARELO = 2L;
	public static final Long ID_VERMELHO = 4L;
	public static final Long ID_PRETO = 5L;
}

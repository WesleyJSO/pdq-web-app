package com.s3.helper;

import com.pdq.pedido.domain.PedidoItem;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PedidoItemHelper extends PedidoItem {

	private static final long serialVersionUID = -3048500342714728110L;
}

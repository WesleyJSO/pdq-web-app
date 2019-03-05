package com.pdq.pedido.helper;

import com.pdq.pedido.domain.Regra;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RegraHelper extends Regra {

	private static final long serialVersionUID = -7113062978348212915L;
	
	private String idPedido;
}

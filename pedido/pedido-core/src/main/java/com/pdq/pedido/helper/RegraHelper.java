package com.pdq.pedido.helper;

import com.pdq.pedido.domain.Regra;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RegraHelper extends Regra {

	private static final long serialVersionUID = -7113062978348212915L;
	
	private String idPedido;
	private Long idStatusPedido;
	
	public static final String DESCRICAO_REGRA_BEAN_BONIFICACAO_GP = "Bonificação";
	public static final String DESCRICAO_REGRA_BEAN_SUPERA = "Programa Supera";
	public static final String DESCRICAO_REGRA_BEAN_GERENTE_DISTRIBUICAO = "Agenciamento";
	public static final String DESCRICAO_REGRA_BEAN_AR = "A.R.";
}

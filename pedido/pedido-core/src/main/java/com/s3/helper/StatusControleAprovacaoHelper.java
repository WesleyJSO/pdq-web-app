package com.s3.helper;

import com.pdq.pedido.domain.StatusControleAprovacao;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author Bruno Holanda
* Muralis Acessoria e Tecnologia Ltda.
* @date 8 de mar de 2019
*/

@Data
@EqualsAndHashCode(callSuper=false)
public class StatusControleAprovacaoHelper extends StatusControleAprovacao {
	
	private static final long serialVersionUID = -2932511013630164739L;
	
	public static final Long ID_PENDENTE = 1L;
	public static final Long ID_APROVADO = 2L;
	public static final Long ID_REPROVADO = 3L;
	public static final Long ID_CANCELADO = 4L;

}

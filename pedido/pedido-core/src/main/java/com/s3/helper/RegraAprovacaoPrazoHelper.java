package com.s3.helper;

import com.pdq.pedido.domain.RegraAprovacaoPrazo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 21 de abr de 2019
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RegraAprovacaoPrazoHelper extends RegraAprovacaoPrazo {

	private static final long serialVersionUID = 8699869712661910971L;

	private Long idLinhaProduto;
	private Integer diasPrazoPagamento;
}

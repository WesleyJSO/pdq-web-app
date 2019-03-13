package com.pdq.pedido.helper;

import java.util.List;

import com.pdq.pedido.domain.CondicaoPagamento;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
 *
 * @author Bruno Holanda - Muralis
 * @date 13 de mar de 2019
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CondicaoPagamentoHelper extends CondicaoPagamento {

	private static final long serialVersionUID = 3659275118977302657L;
	
	private List<Long> idList;

}

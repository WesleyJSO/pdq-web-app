package com.s3.helper;

import com.pdq.pedido.domain.LinhaProduto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 19 de abr de 2019
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LinhaProdutoHelper extends LinhaProduto {

	private static final long serialVersionUID = 4799702568608859372L;
	
	private Long idUsuario;

}

package com.pdq.pedido.bean.aprovacao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.Result;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.RegraHelper;

/**
 * @author Bruno Holanda - Muralis
 * @date 13 de mar de 2019
 *
 */
@Component
public class ARRegraAprovacao extends RegraAprovacao {

	@Override
	public Result validar(Pedido pedido, List<PedidoItem> lstPedidoItem) {

		Result result = new Result();
		
		if (pedido.getAr()) {
			result.addEntity(true);
		} else {
			result.addEntity(false);
		}
		return result;
	}

	@Override
	public String getRegraDescricao() {
		return RegraHelper.DESCRICAO_REGRA_BEAN_AR;
	}

}
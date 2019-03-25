package com.pdq.pedido.bean.aprovacao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.Filter;
import com.dvsmedeiros.bce.domain.Result;
import com.pdq.pedido.dao.impl.CondicaoPagamentoDAO;
import com.pdq.pedido.domain.CondicaoPagamento;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.helper.CondicaoPagamentoHelper;
import com.pdq.pedido.helper.RegraHelper;

/**
 * @author Bruno Holanda - Muralis
 * @date 13 de mar de 2019
 *
 */
@Component
public class ProgramaSuperaRegraAprovacao extends RegraAprovacao {
	
	@Autowired
	private CondicaoPagamentoDAO condicaoPagamentoDao;

	@Override
	public Result validar(Pedido pedido, List<PedidoItem> lstPedidoItem) {

		Result result = new Result();

		CondicaoPagamentoHelper condicaoPagamentoHelper = new CondicaoPagamentoHelper();
		condicaoPagamentoHelper.setIdList(Arrays.asList(CondicaoPagamento.IDS_CONDICOES_SUPERA));
		Filter<CondicaoPagamentoHelper> filter = new Filter<>();
		filter.setEntity(condicaoPagamentoHelper);

		List<CondicaoPagamento> condicoesSupera = condicaoPagamentoDao.findByMultipleId(filter)
				.collect(Collectors.toList());

		for (PedidoItem pedidoItem : lstPedidoItem) {
			if (condicoesSupera.contains(pedidoItem.getCondicaoPagamento())) {
				result.addEntity(true);
				return result;
			}
		}

		result.addEntity(false);
		return result;
	}

	@Override
	public String getRegraDescricao() {
		return RegraHelper.DESCRICAO_REGRA_BEAN_SUPERA;
	}

}
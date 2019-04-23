package com.s3.business.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.LinhaProduto;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;
import com.pdq.pedido.domain.RegraAprovacaoPrazo;
import com.pdq.utils.DomainEntity;
import com.s3.dao.impl.RegraDAO;
import com.s3.helper.RegraAprovacaoPrazoHelper;
/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 21 de abr de 2019
 *
 */
@SuppressWarnings("rawtypes")
@Component
public class FindTermRules implements IStrategy<DomainEntity> {

	@Autowired
	private RegraDAO regraDAO;

	@Override
	public void process(DomainEntity aEntity, INavigationCase<DomainEntity> aCase) {
		Optional<Pedido> optional = aCase.getResult().getEntity();
		Pedido pedido = optional.get();
		List<PedidoItem> listaPedidoItem = pedido.getListPedidoItem();
		List<RegraAprovacaoPrazo> regras = new ArrayList<>();
		for (PedidoItem pedidoItem : listaPedidoItem) {
			LinhaProduto linhaProduto = pedidoItem.getProdutoPrecoRegras().getLinhaProduto();
			Integer periodo = pedidoItem.getCondicaoPagamento().getDiasPagamento() == null ? 0
					: Integer.valueOf(pedidoItem.getCondicaoPagamento().getDiasPagamento());

			LocalDateTime dIni = pedido.getDtCriacaoPedido();
			LocalDateTime dFim;

			if (pedidoItem.getDataPagamento() != null) {
				dFim = pedidoItem.getDataPagamento();
			} else if (pedidoItem.getDataFaturamento() != null) {
				dFim = pedidoItem.getDataFaturamento();
			} else {
				error(aCase, "O item " + pedidoItem.getProdutoPrecoRegras().getProduto().getDesProduto()
						+ " não possui data de faturamento nem pagamento.", true);
				return;
			}

			int prazoPagamento = (int) ChronoUnit.DAYS.between(dIni, dFim);
			prazoPagamento += periodo;

			RegraAprovacaoPrazoHelper regraHelper = new RegraAprovacaoPrazoHelper();
			regraHelper.setIdLinhaProduto(linhaProduto.getId());
			regraHelper.setDiasPrazoPagamento(prazoPagamento);
			Filter<RegraAprovacaoPrazoHelper> regraFilter = new Filter<>();
			regraFilter.setEntity(regraHelper);

			List<RegraAprovacaoPrazo> regrasPedidoItem = regraDAO.findAprovacaoPrazoByPedidoItem(regraFilter)
					.collect(Collectors.toList());

			if (null == regras) {
				error(aCase, "Erro ao consultar as regra de prazo de pagamento para o item "
						+ pedidoItem.getProdutoPrecoRegras().getProduto().getDesProduto() + ".", true);
			} else {
				regras.addAll(regrasPedidoItem);
			}
		}
		aCase.getResult().addEntity("findTermRulesResult", regras.stream());
	}

	private void error(INavigationCase<DomainEntity> aCase, String message, boolean suspend) {
		aCase.getResult().setError();
		aCase.getResult().setMessage(message);
		if (suspend)
			aCase.suspendExecution();
	}
}

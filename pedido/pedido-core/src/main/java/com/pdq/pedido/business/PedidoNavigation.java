package com.pdq.pedido.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.pedido.business.impl.ChangeStatus;
import com.pdq.pedido.business.impl.ComputeApprovementList;
import com.pdq.pedido.business.impl.FillPeditoItemList;
import com.pdq.pedido.business.impl.FilterByCodSap;
import com.pdq.pedido.business.impl.FilterPedidoByRegionalUsuario;
import com.pdq.pedido.business.impl.FilterPedidoByStatusBonificacao;
import com.pdq.pedido.business.impl.FindPedidoByFilter;
import com.pdq.pedido.business.impl.FindPedidoById;
import com.pdq.pedido.business.impl.GenerateStatusHistory;
import com.pdq.pedido.helper.PedidoHelper;

@Configuration
public class PedidoNavigation {

	@Autowired private FindPedidoByFilter findPedidoByFilter;
	@Autowired private FilterPedidoByRegionalUsuario filterPedidoByRegionalUsuario;
	@Autowired private FilterPedidoByStatusBonificacao filterPedidoByStatusBonificacao;
	@Autowired private FilterByCodSap filterByCodSap;
	@Autowired private FillPeditoItemList fillPeditoItemList;
	@Autowired private ComputeApprovementList computeApprovementList;
	@Autowired private ChangeStatus changeStatus;
	@Autowired private FindPedidoById findPedidoById;
	@Autowired private GenerateStatusHistory generateStatusHistory;
	
	@Bean(name = "FIND_PEDIDO_BY_FILTER")
	public Navigation<PedidoHelper> findPedidoByFilter() {
		return new NavigationBuilder<PedidoHelper>()
				.next(findPedidoByFilter)
				.build();
	}
	
	@Bean(name = "FILTER_PEDIDO_BY_STATUS")
	public Navigation<PedidoHelper> filterPedidoByStatus() {
		return new NavigationBuilder<PedidoHelper>()
				.next(findPedidoByFilter)
				.next(filterPedidoByRegionalUsuario)
				.next(filterPedidoByStatusBonificacao)
				.build();
	}

	@Bean(name = "COMPUTE_APPROVEMENT_LIST")
	public Navigation<PedidoHelper> computeApprovementList() {
		return new NavigationBuilder<PedidoHelper>()
				.next(findPedidoById)
				.next(fillPeditoItemList)
				.next(computeApprovementList)
				.next(changeStatus)
				.next(generateStatusHistory)
				.build();
	}
	
	@Bean(name = "FILTER_BY_COD_SAP")
	public Navigation<PedidoHelper> filterByCodSap() {
		return new NavigationBuilder<PedidoHelper>()
				.next(filterByCodSap)
				.build();
	}
}

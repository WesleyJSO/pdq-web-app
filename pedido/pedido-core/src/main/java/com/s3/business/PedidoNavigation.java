package com.s3.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.s3.business.impl.ChangePedidoItemStatus;
import com.s3.business.impl.ChangeStatusControleAprovacao;
import com.s3.business.impl.ChangeStatusPedido;
import com.s3.business.impl.CheckPedidoPedidoItem;
import com.s3.business.impl.ComputeApprovementList;
import com.s3.business.impl.CreateSapOrderObject;
import com.s3.business.impl.FilterByCodSap;
import com.s3.business.impl.FilterPedidoByRegionalUsuario;
import com.s3.business.impl.FilterPedidoByStatusBonificacao;
import com.s3.business.impl.FindPedidoByFilter;
import com.s3.business.impl.FindPedidoById;
import com.s3.business.impl.FindTermRules;
import com.s3.business.impl.GenerateStatusHistory;
import com.s3.business.impl.SendOrderToSap;
import com.s3.helper.PedidoHelper;

@Configuration
public class PedidoNavigation {

	@Autowired private FindPedidoByFilter findPedidoByFilter;
	@Autowired private FilterPedidoByRegionalUsuario filterPedidoByRegionalUsuario;
	@Autowired private FilterPedidoByStatusBonificacao filterPedidoByStatusBonificacao;
	@Autowired private FilterByCodSap filterByCodSap;
	@Autowired private ComputeApprovementList computeApprovementList;
	@Autowired private ChangeStatusPedido changeStatusPedido;
	@Autowired private FindPedidoById findPedidoById;
	@Autowired private GenerateStatusHistory generateStatusHistory;
	@Autowired private ChangeStatusControleAprovacao changeStatusControleAprovacao;
	@Autowired private CreateSapOrderObject createSapOrderObject;
	@Autowired private SendOrderToSap sendOrderToSap;
	@Autowired private FindTermRules findTermRules;
	@Autowired private ChangePedidoItemStatus changePedidoItemStatus;
	@Autowired private CheckPedidoPedidoItem checkPedidoPedidoItem;
	
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
				.next(checkPedidoPedidoItem)
				.next(findTermRules)
				.next(computeApprovementList)
				.next(changePedidoItemStatus)
				.next(changeStatusPedido)
				.next(generateStatusHistory)
				.build();
	}

	@Bean(name = "CHANGE_ORDER_STATUS")
	public Navigation<PedidoHelper> changeOrderStatus() {
		return new NavigationBuilder<PedidoHelper>()
				.next(findPedidoById)
				.next(checkPedidoPedidoItem)
				.next(findTermRules)
				.next(changeStatusControleAprovacao)
				.next(changePedidoItemStatus)
				.next(changeStatusPedido)
				.next(createSapOrderObject)
				.next(sendOrderToSap)
				.next(generateStatusHistory)
				.build();
	}
	
	@Bean(name = "FILTER_BY_COD_SAP")
	public Navigation<PedidoHelper> filterByCodSap() {
		return new NavigationBuilder<PedidoHelper>()
				.next(filterByCodSap)
				.build();
	}
	
	@Bean(name = "VALIDATE_PEDIDO_PEDITO_ITEM_EXISTENCE")
	public Navigation<PedidoHelper> validatePedidoPedidoItemExistence() {
		return new NavigationBuilder<PedidoHelper>()
				.next(findPedidoById)
				.next(checkPedidoPedidoItem)
				.build();
	}
}

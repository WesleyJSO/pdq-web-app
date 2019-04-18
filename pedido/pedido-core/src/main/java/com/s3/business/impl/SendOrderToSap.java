package com.s3.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.core.controller.INavigationCase;
import com.dvsmedeiros.bce.core.controller.business.IStrategy;
import com.dvsmedeiros.bce.domain.Result;
import com.s3.helper.ParametroHelper;
import com.s3.helper.PedidoHelper;
import com.s3.helper.StatusPedidoHelper;
import com.s3.repository.ParametroRepository;
import com.s3.sap.z_pedido_novo_sap.TableOfZsdeErroPedidoWebs;
import com.s3.sap.z_pedido_novo_sap.ZbcPedidoNovoArtWebs;
import com.s3.service.sap.PedidoNovoService;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 11-04-2019 16:31:35
 *
 */
@Component
public class SendOrderToSap implements IStrategy<PedidoHelper> {

	@Autowired private PedidoNovoService pedidoNovoService;
	@Autowired private ParametroRepository parametroRepository;
	
	@Override
	public void process(PedidoHelper aEntity, INavigationCase<PedidoHelper> aCase) {
		
		
		if (aEntity != null 
				&& aEntity.getStatusPedido() != null 
				&& StatusPedidoHelper.ID_STATUS_VERIFICACAO_ADM_VENDAS.equals(aEntity.getStatusPedido().getId())) {
			
			ZbcPedidoNovoArtWebs request = new ZbcPedidoNovoArtWebs();
			request.setIChAcesso(parametroRepository.findById(ParametroHelper.PARAMETER_SAP_WS_KEY).get().getValParametro());
			request.setTabPedido(aCase.getResult().getEntity());
			request.setTabErroPedido(new TableOfZsdeErroPedidoWebs());
			Result r = pedidoNovoService.execute(request);
			if(r.hasError()) {
				aCase.getResult().setError();
				aCase.getResult().setMessage(r.getMessage());
				aCase.isSuspendExecution();
			} else
				aCase.getResult().addEntity(r.getEntity());
		}
	}
}
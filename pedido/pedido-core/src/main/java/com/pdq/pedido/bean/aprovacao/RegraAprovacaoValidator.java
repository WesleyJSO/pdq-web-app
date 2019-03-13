package com.pdq.pedido.bean.aprovacao;

import java.util.List;

import com.dvsmedeiros.bce.domain.Result;
import com.pdq.pedido.domain.Pedido;
import com.pdq.pedido.domain.PedidoItem;

/**
 * @author Bruno Holanda - Muralis
 * @date 13 de mar de 2019
 *
 */
public interface RegraAprovacaoValidator {

    public Result validar(Pedido pedido, List<PedidoItem> lstPedidoItem);
    
}

package com.pdq.pedido.filter;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.IEntity;
import com.pdq.pedido.domain.StatusPedido;
import com.pdq.usuario.domain.Usuario;
import com.pdq.regional.domain.Cidade;
import com.pdq.regional.domain.Estado;
import com.pdq.regional.domain.Regional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class PedidoHelper implements IEntity {

	private String idPedido;
	private String codSap;
	private Usuario usuarioRtv;
	private Regional regional;
	private Estado estado;
	private Cidade cidade;
	private StatusPedido statusPedido;
}

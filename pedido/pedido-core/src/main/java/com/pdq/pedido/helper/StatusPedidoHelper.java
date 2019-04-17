package com.pdq.pedido.helper;

import com.pdq.pedido.domain.StatusPedido;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class StatusPedidoHelper extends StatusPedido {

	private static final long serialVersionUID = -4362640317435985286L;
	
	public static final Long ID_STATUS_EM_CONSTRUCAO = 1l;
	public static final Long ID_STATUS_APROVACAO_GERENTE_REGIONAL = 2l;
	public static final Long ID_STATUS_APROVACAO_GERENTE_COMERCIAL = 3l;
	public static final Long ID_STATUS_APROVACAO_DIRETOR_COMERCIAL = 4l;
    public static final Long ID_STATUS_APROVACAO_GERENTE_DISTRIBUICAO = 5l;
    public static final Long ID_STATUS_AR = 6l;
	public static final Long ID_STATUS_NAO_APROVADO = 7l;
	public static final Long ID_STATUS_VERIFICACAO_ADM_VENDAS = 8l;
    public static final Long ID_STATUS_ERRO = 9l;
    public static final Long ID_STATUS_IMPLANTADO = 10l;
    public static final Long ID_STATUS_APROVADO = 11l;
	public static final Long ID_STATUS_RECUSADO = 12l;
	public static final Long ID_STATUS_CANCELADO = 13l;
	public static final Long ID_STATUS_APROVACAO_SUPERA = 14l;
	public static final Long ID_STATUS_APROVACAO_BONIFICACAO_GP = 15l;
	public static final Long ID_STATUS_APROVACAO_PRAZO = 16l;
	public static final Long ID_STATUS_ADM_VENDAS_APROVADO_PRAZO_PGMT = 17l;
	public static final Long ID_STATUS_APROVACAO_SUPERA_GMT = 19l;
	public static final Long ID_STATUS_APROVACAO_BONIFICACAO_DIRETOR = 20l;
	
	public static final Long[] IDS_REPROVACAO = {ID_STATUS_NAO_APROVADO, ID_STATUS_RECUSADO, ID_STATUS_CANCELADO, ID_STATUS_ERRO};

	public static Boolean isEndStatus(StatusPedido status){
		if (status.getId().equals(ID_STATUS_IMPLANTADO)
				|| status.getId().equals(ID_STATUS_APROVADO)) {
			return true;
		}
		return false;
	}
}

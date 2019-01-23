package com.pdq.aprovacao.filter;

import com.pdq.aprovacao.domain.Regra;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RegraHelper extends Regra {

	private String idPedido;
}

package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_CONDICAO_PAGAMENTO"))
public class CondicaoPagamento extends DomainEntity<Long> {
	
	private static final long serialVersionUID = -4802485891677783370L;
	
	public static final Long[] IDS_CONDICOES_SUPERA = {50l};
	
	private String codSap;
	private String condPagamento;
	private Integer diasPagamento;
	private boolean ativo;
	
}

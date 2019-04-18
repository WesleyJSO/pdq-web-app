package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 10-04-2019 18:47:17
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
public class VendedorSap extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 7429212480049994047L;

	private String codVendedorSap;
	private String nomeVendedorSap;	
	private String numCnpj;
	private String numCpf;
}

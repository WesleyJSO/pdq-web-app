package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 11:45:44
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "VENDEDOR_SAP")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class VendedorSap extends DomainEntity<Long> {
		
	private static final long serialVersionUID = -2490368437650764808L;
	
	@Column(name = "COD_VENDEDOR_SAP")
	private String codVendedorSap;
	
	@Column(name = "NOME_VENDEDOR_SAP")
	private String nomVendedorSap;	
	
	@Column(name = "NUM_CNPJ")
	private String numCnpj;
	
	@Column(name = "NUM_CPF")
	private String numCpf;

}

package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Bruno Holanda - Muralis
 * @date 9 de abr de 2019
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "ID_ORGANIZACAO_VENDA"))
public class OrganizacaoVenda extends DomainEntity<Long> {
	
	private static final long serialVersionUID = -5802560242158735948L;

	@Column(name = "COD_ORGANIZACAO_VENDAS")
	private String codOrganizacaoVendas;

	@Column(name = "DES_ORGANIZACAO_VENDAS")
	private String desOrganizacaoVendas;

}

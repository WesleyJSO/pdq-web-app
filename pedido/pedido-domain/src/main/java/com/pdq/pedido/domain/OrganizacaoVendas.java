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
@AttributeOverride(name = "id", column = @Column(name = "ID_ORGANIZACAO_VENDA"))
public class OrganizacaoVendas extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 8153517199957613534L;
	
	private String codOrganizacaoVendas;
	private String desOrganizacaoVendas;
}

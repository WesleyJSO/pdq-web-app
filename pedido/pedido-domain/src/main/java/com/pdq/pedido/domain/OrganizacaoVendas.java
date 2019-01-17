package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class OrganizacaoVendas implements IEntity {

	@Id
	private long idOrganizacaoVenda;
	private String codOrganizacaoVendas;
	private String desOrganizacaoVendas;
}

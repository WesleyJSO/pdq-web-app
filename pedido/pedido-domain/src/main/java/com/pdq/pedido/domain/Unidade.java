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
@AttributeOverride(name = "id", column = @Column(name = "COD_UNIDADE"))
public class Unidade extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 671153221516998327L;
	
	private String siglaUnidade;
	
}

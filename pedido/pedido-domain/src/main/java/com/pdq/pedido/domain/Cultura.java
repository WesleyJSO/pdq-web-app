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
@AttributeOverride(name = "id", column = @Column(name = "ID_CULTURA"))
public class Cultura extends DomainEntity<String> {
	
	private static final long serialVersionUID = 3035856302021478627L;
	
	private String codCultura;
	private String desCultura;
}

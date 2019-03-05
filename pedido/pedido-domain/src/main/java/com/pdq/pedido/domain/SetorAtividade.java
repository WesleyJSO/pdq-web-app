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
@AttributeOverride(name = "id", column = @Column(name = "ID_SETOR_ATIVIDADE"))
public class SetorAtividade extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 2087344214467947545L;
	
	private String codSetorAtividade;
	private String desSetorAtividade;

}

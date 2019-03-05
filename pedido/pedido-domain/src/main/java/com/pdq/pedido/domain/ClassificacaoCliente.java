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
@AttributeOverride(name = "id", column = @Column(name = "ID_CLASSIFICACAO_CLIENTE"))
public class ClassificacaoCliente extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 8735629687047105643L;
	
	private String desClassificacaoCliente;
}

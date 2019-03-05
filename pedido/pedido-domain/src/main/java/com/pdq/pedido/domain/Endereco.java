package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_ENDERECO"))
public class Endereco extends DomainEntity<String> {

	private static final long serialVersionUID = -8759443653079647732L;
	
	@ManyToOne
	@JoinColumn(name = "ID_CIDADE")
	private Cidade cidade;
}

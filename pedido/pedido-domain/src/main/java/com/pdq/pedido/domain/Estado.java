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
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 11:45:26
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_ESTADO"))
public class Estado extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 9116698425825862239L;

	@ManyToOne
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;
	
	private String nomEstado;
	private String sigla;
	
}
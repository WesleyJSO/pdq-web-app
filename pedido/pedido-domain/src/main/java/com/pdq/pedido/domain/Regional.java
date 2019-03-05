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
 * 05-03-2019 12:55:07
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_REGIONAL"))
public class Regional extends DomainEntity<Long> {

	private static final long serialVersionUID = 6031243901798703077L;

	private String nomRegional;	
	
	@ManyToOne
	@JoinColumn(name = "ID_CENTRO_LUCRO")
	private CentroLucro centroLucro;
}

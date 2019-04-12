package com.pdq.pedido.domain;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 11-04-2019 13:41:47
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "NOM_PARAMETRO"))
public class Parametro extends DomainEntity<String> {

	private static final long serialVersionUID = 7350367645160299119L;
	
	private Boolean editavel;
	private String descParametro;
	private String valParametro;
	private LocalDateTime dtSincronismo;
}

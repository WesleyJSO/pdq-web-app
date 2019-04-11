package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Bruno Holanda - Muralis
 * @date 9 de abr de 2019
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "ID_DEPOSITO"))
public class Deposito extends DomainEntity<Long> {

	private static final long serialVersionUID = 4905315545867274595L;

	@Column(name="COD_DEPOSITO")
	private String codDeposito;

	@Column(name="DES_DEPOSITO")
	private String desDeposito;
}
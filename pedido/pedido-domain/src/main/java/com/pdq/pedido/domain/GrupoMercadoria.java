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
@AttributeOverride(name = "id", column = @Column(name = "ID_GRUPO_MERCADORIA"))
public class GrupoMercadoria extends DomainEntity<Long> {

	private static final long serialVersionUID = 540744698793559098L;

	@Column(name = "COD_GRUPO_MERCADORIA")
	private String codGrupoMercadoria;

	@Column(name = "DES_GRUPO_MERCADORIA")
	private String desGrupoMercadoria;

}

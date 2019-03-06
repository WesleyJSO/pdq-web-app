package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@AttributeOverride(name = "id", column = @Column(name = "ID_REGIONAL_USUARIO"))
public class RegionalUsuario extends DomainEntity<Long> {

	private static final long serialVersionUID = 4852862058681302763L;

	private boolean possuiAcessoCidade;

	@ManyToOne
	@JoinColumn(name = "ID_REGIONAL")
	private Regional regional;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CIDADE")
	private Cidade cidade;
}

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
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class Produto extends DomainEntity<String> {
	
	private static final long serialVersionUID = 7685245106358697123L;
	
	private Long idProduto;
	private Double embalagem;
	private Double dose;
	private Double densidade;
	private Boolean ativo;
	private Long codOrigemMaterial;
	private String desProduto;
	private String unidade;
	private String ncm;

	@ManyToOne
	@JoinColumn(name = "ID_MOEDA")
	private Moeda moeda;

}

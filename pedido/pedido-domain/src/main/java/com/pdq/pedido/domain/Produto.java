package com.pdq.pedido.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Produto implements IEntity, Serializable {

	private static final long serialVersionUID = -3528859604605978578L;
	
	@Id
	private long id;
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

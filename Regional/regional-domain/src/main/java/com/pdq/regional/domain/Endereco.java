package com.pdq.regional.domain;

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
public class Endereco implements IEntity {

	@Id
	private String idEndereco;

	@ManyToOne
	@JoinColumn(name = "ID_CIDADE")
	private Cidade cidade;
}

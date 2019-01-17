package com.pdq.pedido.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;
import com.pdq.regional.domain.Endereco;

import lombok.Data;

@Data
@Table
@Entity
public class Cliente implements IEntity {
	
	@Id
	private String idCliente;
	private String nomCliente;
	private String numIe;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;
}

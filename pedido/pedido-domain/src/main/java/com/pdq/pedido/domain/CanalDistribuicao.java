package com.pdq.pedido.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Table
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCanalDistribuicao")
public class CanalDistribuicao implements IEntity {
	
	@Id
	private Long idCanalDistribuicao;
	private String codCanalDistribuicao;
	private String desCanalDistribuicao;

	@OneToMany(mappedBy = "canalDistribuicao", fetch = FetchType.LAZY)
	List<Cliente> listCliente;
}

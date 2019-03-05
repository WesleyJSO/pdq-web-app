package com.pdq.pedido.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_CANAL_DISTRIBUICAO"))
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CanalDistribuicao extends DomainEntity<Long> {
	
	private static final long serialVersionUID = 6645382193010489243L;
	
	private String codCanalDistribuicao;
	private String desCanalDistribuicao;

	@OneToMany(mappedBy = "canalDistribuicao", fetch = FetchType.LAZY)
	List<Cliente> listCliente;
}

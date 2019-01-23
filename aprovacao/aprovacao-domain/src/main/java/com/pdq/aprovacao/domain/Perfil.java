package com.pdq.aprovacao.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Entity
@Table
public class Perfil implements IEntity {
	
	@Id
	private long idPerfil;
	private String desPerfil;
	private String acronimo;
	
	@ManyToMany
	@JoinTable(name = "PERFIL_STATUS_PEDIDO", 
		joinColumns = { @JoinColumn(name = "ID_PERFIL") }, 
		inverseJoinColumns = { @JoinColumn(name = "ID_STATUS_PEDIDO") })
	private List<StatusPedido> listStatusPedido;
	
	
}

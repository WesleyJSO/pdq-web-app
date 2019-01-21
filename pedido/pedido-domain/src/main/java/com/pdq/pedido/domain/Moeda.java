package com.pdq.pedido.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Moeda implements IEntity, Serializable {
	
	private static final long serialVersionUID = -1246705565159522658L;
	
	@Id
	private long idMoeda;
}

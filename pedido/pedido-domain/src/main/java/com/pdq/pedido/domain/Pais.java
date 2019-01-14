package com.pdq.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainSpecificEntity;

//@Data
//@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@Component
public class Pais extends DomainSpecificEntity {

	private String codPais;
	private String nomPais;

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getNomPais() {
		return nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

}

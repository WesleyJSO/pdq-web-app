package com.pdq.pedido.domain;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 10-04-2019 18:28:18
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_TRANSPORTADORA"))
public class Transportadora extends DomainEntity<Long> {

	private static final long serialVersionUID = -8217955842387030579L;

	@Column(name = "COD_SAP")
	private String codSap;

	@Column(name = "DT_SYSDATE")
	private LocalDate dtSysdate;

	@Column(name = "NOM_CONTATO")
	private String nomContato;

	@Column(name = "NOM_RAZAO_SOCIAL")
	private String nomRazaoSocial;

	@Column(name = "NUM_TELEFONE")
	private String numTelefone;

	@Column(name = "NUM_CNPJ")
	private String numCnpj;
}

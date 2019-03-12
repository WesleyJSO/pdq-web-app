package com.pdq.pedido.domain;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@AttributeOverride(name = "id", column = @Column(name = "ID_FUNCIONARIO"))
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Funcionario extends DomainEntity<Long> {
	
	private static final long serialVersionUID = -1371455739017883307L;
	
	private LocalDate dtDataNasc;
	private String codSap;
	private String nomFuncionario;
	private String numCpf;
	private String numCnpj;
	private String numIe;
	private String numTelefone;
	private String numTelCob;
	private String numCelular;
	private String email;
	private String observacao;

	/*@OneToOne(fetch = FetchType.LAZY, mappedBy = "funcionario", cascade = CascadeType.ALL)
	private Usuario usuario;*/

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_END_COB")
	private Endereco enderecoCobranca;
}

package com.pdq.usuario.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pdq.regional.domain.Endereco;

import lombok.Data;

@Data
@Table
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idFuncionario")
public class Funcionario implements IEntity {
	
	@Id
	private Long idFuncionario;
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "funcionario", cascade = CascadeType.ALL)
	private Usuario usuario;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_END_COB")
	private Endereco enderecoCobranca;
}

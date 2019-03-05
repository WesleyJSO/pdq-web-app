package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_CLIENTE"))
public class Cliente extends DomainEntity<String> {

	private static final long serialVersionUID = -1771388937880370757L;
	
	private Long codSap;
	private String nomCliente;
    private String numCelular;
    private String numCnpj;
    private String numCpf;
	private String numIe;
    private String numTelefone;
    private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "ID_CANAL_DISTRIBUICAO")
	private CanalDistribuicao canalDistribuicao;
}

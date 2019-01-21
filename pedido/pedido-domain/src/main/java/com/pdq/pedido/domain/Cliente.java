package com.pdq.pedido.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

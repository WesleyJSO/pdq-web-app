package com.pdq.pedido.domain;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_CAMPANHA"))
public class Campanha extends DomainEntity<Long> {

	private static final long serialVersionUID = 5157889896893903790L;
	
	private String nomeCampanha;
	private String descricaoCampanha;
	private LocalDate vigenciaInicio;
	private LocalDate vigenciaFim;
	private LocalDate dtCarregamentoInicio;
	private LocalDate dtCarregamentoFim;
	private LocalDate aplicacaoJurosAposData;
	private Integer aplicacaoJurosAposDias;		
	private Integer prazoPagamentoDias;
	private LocalDate prazoPagamentoInicio;
	private LocalDate prazoPagamentoFim;
	private Double descontoFrete;
	private Boolean kit;
	private String observacoesGerais;
	private Integer metasCumprir;
	private Integer quantidadeRealizadaSobreMeta;
}

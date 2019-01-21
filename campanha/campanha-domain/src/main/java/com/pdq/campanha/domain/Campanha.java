package com.pdq.campanha.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Campanha implements IEntity {

	@Id
	private long idCampanha;
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

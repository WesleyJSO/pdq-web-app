package com.pdq.aprovacao.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
public class RegraAprovacaoPrazo extends Regra {

	private int numeroDiasInicio;
	private int numeroDiasFim;
	private LocalDate dtInicio;
	private LocalDate dtFim;
}

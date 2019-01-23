package com.pdq.aprovacao.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pdq.usuario.domain.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table
@Entity
public class RegraAprovacaoPrazo extends Regra {

	private int numeroDiasInicio;
	private int numeroDiasFim;
	private LocalDate dtInicio;
	private LocalDate dtFim;

	@ManyToOne
	@Column(name = "ID_USUARIO")
	private Usuario usuario;
}

package com.pdq.pedido.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;

@Data
@Table
@Entity
public class TabelaPreco implements IEntity {
	
	@Id
	private long idTabelaPreco;
	private LocalDate dtIni;
	private LocalDate dtFim;
	private String desTabelaPreco;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_TABELA")
	private TipoTabela tipoTabela;
}

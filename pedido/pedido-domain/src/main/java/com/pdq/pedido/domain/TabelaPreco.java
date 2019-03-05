package com.pdq.pedido.domain;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_TABELA_PRECO"))
public class TabelaPreco extends DomainEntity<Long> {
	
	private static final long serialVersionUID = -7110102402390082424L;
	
	private LocalDate dtIni;
	private LocalDate dtFim;
	private String desTabelaPreco;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_TABELA")
	private TipoTabela tipoTabela;
}

package com.pdq.pedido.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 13:36:24
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "REGRAS_APROVACAO_PRAZO")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_REGRA_PRAZO"))
public class RegraAprovacaoPrazo extends Regra {

	private static final long serialVersionUID = -8928966767401397813L;
	
	@Column(name = "NUM_DIAS_INI")
	private Integer prazoPagamentoInicio;

	@Column(name = "NUM_DIAS_FIM")
	private Integer prazoPagamentoFim;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO_APROVADOR")
	private Usuario aprovador;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "APROVACAO_PRAZO_LINHA_PRODUTO", joinColumns = { @JoinColumn(name = "ID_REGRA_PRAZO") }, inverseJoinColumns = { @JoinColumn(name = "ID_LINHA_PRODUTO") })
    private List<LinhaProduto> lstLinhaProduto;

	@Column(name = "DT_INI")
	private LocalDate dataVigenciaInicio;

	@Column(name = "DT_FIM")
	private LocalDate dataVigenciaFim;

	@Column(name = "STS_ATIVO")
	private Boolean ativo;

	@Column(name = "DT_SINCRONISMO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSincronismo;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
}

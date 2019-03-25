package com.pdq.pedido.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author José Wesley Silva Muralis Assessoria e Tecnologia Ltda. 05-03-2019
 *         13:35:58
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class Regra extends DomainEntity<Long> {

	private static final long serialVersionUID = 4203772712737613752L;
	private String descricao;
	private boolean ativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERFIL")
	private Perfil perfil;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "STATUS_PEDIDO_REGRA", joinColumns = {
			@JoinColumn(name = "ID_REGRA") }, inverseJoinColumns = { @JoinColumn(name = "ID_STATUS_PEDIDO") })
	private List<StatusPedido> listStatusPedido;
}

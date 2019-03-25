package com.pdq.utils;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.dvsmedeiros.bce.domain.IEntity;

import lombok.Data;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 14:02:33
 *
 * @param <T>
 */
@Data
@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class DomainEntity<T extends Object> implements IEntity, Serializable {
	
	private static final long serialVersionUID = 4251629767487527585L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private T id;
}

package com.pdq.utils;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 05-03-2019 14:02:46
 *
 * Need to be implemented by every domain entity
 * @param <T> Domain entity
 * @param <R> Domain entity Id type
 */
public interface IRepository<T extends DomainEntity<R>, R extends Object> extends JpaRepository<T, R> { }

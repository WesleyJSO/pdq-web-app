package com.pdq.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvsmedeiros.bce.domain.DomainSpecificEntity;

@Entity
@Table
public class Order extends DomainSpecificEntity { 

	@Id @Column(name="ID_PEDIDO")
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}

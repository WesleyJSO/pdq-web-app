package com.pdq.order.core.bussiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dvsmedeiros.bce.core.controller.impl.Navigation;
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder;
import com.pdq.order.core.bussiness.impl.FindOrder;
import com.pdq.order.domain.Order;

@Configuration
public class OrderNavigation {

	@Autowired private FindOrder findOrder;
	
	@Bean(name = "FILTER_ORDER")
	public Navigation<Order> generateReport() {
		return new NavigationBuilder<Order>()
				.next(findOrder)
				.build();
	}
}

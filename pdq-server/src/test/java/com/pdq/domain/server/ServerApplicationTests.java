package com.pdq.domain.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServerApplicationTests {

	// @Autowired private Pedido pedido;
		
	@Test
	public void givenEvenNumver_whenCheckingIsNumverEven_thenTrue() {
		// boolean result = pedido.isNumberEven(8);
		// Assertions.assertTrue(result);
		// Assertions.assertTimeout(Duration.ofMillis(10000),  () -> pedido.isNumberEven(3));
	}
	
	/*@Test
	public void givenOddNumber_whenCheckingIsNumberEven_thenFalse() {
		// boolean result = pedido.isNumberEven(3);
		// Assertions.assertFalse(result);
		Assertions.assertThrows(NullPointerException.class, () -> pedido.isNumberEven(null));
	}*/
}

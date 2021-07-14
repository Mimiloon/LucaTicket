package com.ejemplos.spring;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.EventController;

@SpringBootTest
class Test03_TestingController {
	
	
	@Autowired
	private EventController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

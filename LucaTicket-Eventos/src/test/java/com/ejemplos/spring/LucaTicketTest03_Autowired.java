package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.EventController;

@SpringBootTest
class Test02_Autowired {
	
	
	@Autowired
	private EventController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

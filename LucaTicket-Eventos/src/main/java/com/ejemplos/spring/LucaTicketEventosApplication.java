package com.ejemplos.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories("com.ejemplos.spring.repository")
public class LucaTicketEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketEventosApplication.class, args);
	}

}

package com.ejemplos.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class LucaTicketUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketUsuariosApplication.class, args);
		

		}

}

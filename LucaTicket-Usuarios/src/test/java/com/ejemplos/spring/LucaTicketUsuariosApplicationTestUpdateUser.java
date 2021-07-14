package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.UserController;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;
import com.ejemplos.spring.service.UserService;

/**
 * Nombre Clase: LucaTicketUsuariosApplicationTestUpdateUser.java 
 * Descripcion: Clase que recoge las pruebas Mock del updateUser 
 * Fecha: 14/07/2021
 * Version: 1.0 
 * Autor: Rocio Jiménez Moreno, Sara Sevillano García
 **/

@SpringBootTest
public class LucaTicketUsuariosApplicationTestUpdateUser {

	@InjectMocks
	UserController controller;

	@Mock
	UserRepository repo;

	@Mock
	UserService servi;

	/**
	* Prueba que valida que se actualiza el usuario a la BBDD *
	*/
	@Test
	public void testUpdateUser() {

		User u = new User("10s", "Luis", "Sancho", "l@gmail.com", "123");

		repo.save(u);
		u.setDni("27837");
		User u1 = repo.save(u);
		assertThat(u).isNotEqualTo(u1);

	}
}

package com.ejemplos.spring;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.UserController;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;
import com.ejemplos.spring.service.UserService;

/**
 * Nombre Clase: LucaTicketUsuariosApplicationTestDeleteUser.java
 * Descripcion: Clase que recoge las pruebas Mock del deleteUser 
 * Fecha: 12/07/2021
 * Version: 1.0
 * Autor: Rocio Jiménez Moreno 
 *  
 **/

@SpringBootTest
public class LucaTicketUsuariosApplicationTestsDeleteUser {

	@InjectMocks
	UserController controller;

	@Mock
	UserRepository repo;
	
	@Mock
	UserService servi;
	
	User u = new User("10s", "Luis", "Sancho", "l@gmail.com", "123");
	
	/**
	* Prueba que valida que se elimina el usuario a la BBDD *
	*/
	@Test
	public void testDeleteUser() {
		servi.deleteUserByDNI(u.getDni());   
		verify(servi, times(1)).deleteUserByDNI(u.getDni());  
	}

}



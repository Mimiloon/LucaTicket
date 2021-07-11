package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ejemplos.spring.controller.UserController;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;
import com.ejemplos.spring.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserControllerAplicationTest {

	@Autowired
	UserController controller;

	@Mock
	UserRepository repo;

	@MockBean
	UserService servi;

	User u = new User("15435308W", "Rocío", "Jiménez Moreno", "rocio.jimenezmoreno8@gmail.com", "123456");

	User u1 = new User("1111111W", "Rigoberta", "Jiménez Moreno", "rocio.jimenezmoreno8@gmail.com", "123456");

	User us = new User("", "Rocío", "Jiménez Moreno", "rocio.jimenezmoreno8@gmail.com", "123456");

	/**
	 * Prueba que valida que se añade el usuario a la BBDD *
	 */
	@Test
	public void testAddUser() {
		System.out.println("-------------------------- Iniciando test");
		User u2 = new User("154353089", "Rocío", "Jiménez Moreno", "rocio.jimenezmoreno8@gmail.com", "123456");
		User u3 = repo.save(u2);
		System.out.println("--------------------------" + u3);
		when(servi.saveUser(u)).thenReturn(u);
		controller.addUser(u);
		verify(servi).saveUser(u);
		assertThat(controller.addUser(u)).isEqualTo(u);
	}

	/**
	 * Prueba que valida que no se puede añadir usuario con Dni nulo a la BBDD *
	 */
	@Test
	public void testAddUserifDniIfNotNull() {
		assertThat(servi.findByDNI(us.getDni()).isEmpty());
	}

	/**
	 * Prueba que valida que existe usuario con ese Dni en nuestra BBDD *
	 */
	@Test
	public void testExistsDni() {
//servi.findByDNI(u.getDni());
		assertThat(servi.findByDNI(u.getDni()).equals(repo.existsById(u.getDni())));

	}

}

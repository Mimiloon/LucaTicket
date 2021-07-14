package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.UserController;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;
import com.ejemplos.spring.service.UserServiceImpl;

/**
 * Nombre Clase: LucaTicketUsuariosApplicationTestAddUser.java Descripcion:
 * Clase que recoge las pruebas Mock del addUser Fecha: 12/07/2021 Version: 1.0
 * Autor: Rocio Jiménez Moreno, Ana Maria Ramirez Dorado 
 * 
 **/

@SpringBootTest
public class LucaTicketUsuariosApplicationTestAddUser {

	@InjectMocks
	UserController controller;

	@Mock
	UserRepository repo;

	@Mock
	UserServiceImpl servi;
	
	@InjectMocks
	UserServiceImpl service;

	List<User> list = new ArrayList<User>();
	{
		User u = new User("15435302W", "Rocio", "Jiménez Moreno", "rocio.jimenezmoreno8@gmail.com", "123456");
		User u2 = new User("1111111W", "Rigoberta", "Amarillo Moreno", "rigoberta@gmail.com", "11111");
		User u3 = new User("2222222X", "Ivan", "Santos Perez", "ivansantos@gmail.com", "333456");
		list.add(u);
		list.add(u2);
		list.add(u3);
	}

	/**
	 * Prueba que valida que se añade el usuario a la BBDD *
	 */
	@Test
	void addUserTest1() throws Exception {

		User u = new User("15435302W", "Rocío", "Jiménez Moreno", "rocio.jimenezmoreno8@gmail.com", "123456");

		when(repo.save(u)).thenReturn(u);
		assertEquals(repo.save(u), u);

	}

	/**
	 * Prueba que valida que la lista de usuarios no son nulos *
	 */
	@Test
	public void allUsersNotNullTest() {
		when(repo.findAll()).thenReturn(list);
		assertNotNull(repo.findAll());
	}

	/**
	 * Prueba que valida que la lista de usuarios esta vacia *
	 */
	@Test
	public void UserListEmptyTest() {
		assertThat(repo.findAll()).isEmpty();
	}

	/**
	 * Prueba que valida el tamaño de la lista de usuarios *
	 */
	@Test
	public void getAllUserListTest() {
		when(repo.findAll()).thenReturn(list);
		List<User> empList = service.findAllUsers();    
		assertEquals(3, empList.size());
		verify(repo, times(1)).findAll();
	}
	
	/**
	 * Prueba que valida que se devuelven todos lo usuarios *
	 */
	@Test
	public void returnAllUsers() {
		when(repo.findAll()).thenReturn(list);
		assertEquals(repo.findAll(), list);
	}

	/**
	 * Prueba que valida que existe usuario con ese Dni en nuestra BBDD *
	 */
	@Test
	public void testExistsDni() {

		Optional<User> u = Optional.ofNullable(new User("10s", "Luis", "Sancho", "l@gmail.com", "123"));

		when(servi.findByDNI("10s")).thenReturn(u);
		assertEquals(servi.findByDNI("10s"), u);

	}

	/**
	 * Prueba que encuentra ese usuario con ese Dni en nuestra BBDD *
	 */
	@Test
	public void testfindByDNI() {

		assertNotNull(servi.findByDNI("10s"));
		verify(servi, times(1)).findByDNI("10s");

	}

}

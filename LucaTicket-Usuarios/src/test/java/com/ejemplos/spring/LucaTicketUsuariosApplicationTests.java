package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ejemplos.spring.controller.UserController;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;
import com.ejemplos.spring.service.UserServiceImpl;

@SpringBootTest
class LucaTicketUsuariosApplicationTests {

	private static final Logger log = Logger.getLogger("LucaTicketUsuariosApplicationTests.class");
	@Autowired
	UserRepository repo;

	@MockBean
	UserServiceImpl servi;
	
	@Autowired
	UserController control;

	@Test
	void contextLoads() {
	/**
	* Prueba que comprueba que la aplicación se carga correctamente *
	*/
	assertThat(true).isTrue();
	}

	@Test
	void testVerifyDataBase() {
	log.info("Validar Conexión con la Base de Datos");
	log.info(""+repo.findAll());
	}
	/** * Prueba que valida que se añade el u... de Rocio Jimenez Moreno
	Rocio Jimenez Moreno20:59
	/**
	* Prueba que valida que se añade el usuario a la BBDD *
	*/
//	@Test
//	public void testAddUser() {
//	System.out.println("-------------------------- Iniciando test");
//	User u2 = new User("154353089", "Rocío", "Jiménez Moreno", "rocio.jimenezmoreno8@gmail.com", "123456");
//	User u3 = repo.save(u2);
//	System.out.println("--------------------------"+u3);
//
//	when(servi.saveUser(u2)).thenReturn(u2);
//	assertThat(u2).isEqualTo(u3);
//	}
}

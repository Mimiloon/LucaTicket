package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.repository.UserRepository;

/**
 * Nombre Clase: LucaTicketUsuariosApplicationTest.java
 * Descripcion: Clase que recoge las pruebas para comprobar que la aplicación carga correctamente y validar la BBDD
 * Fecha: 12/07/2021
 * Version: 1.0
 * Autor: Rocio Jiménez Moreno 
 *  
 **/

@SpringBootTest
class LucaTicketUsuariosApplicationTests {

	private static final Logger log = Logger.getLogger("LucaTicketUsuariosApplicationTests.class");
	
	@Autowired
	UserRepository repo;

	/**
	 * Prueba que comprueba que la aplicación se carga correctamente *
	 */
	@Test
	void contextLoads() {
		assertThat(true).isTrue();
	}
	
	/**
	* Prueba que valida que la conexión con la BBDD *
	*/
	@Test
	void testVerifyDataBase() {
		log.info("Validar Conexión con la Base de Datos");
		log.info("" + repo.findAll());
	}

}

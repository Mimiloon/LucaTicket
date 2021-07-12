package com.ejemplos.spring;
/**
 * @author Ana Díaz
 * @author Rebeca Martínez
 * @author Rocío Jiménez */
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ejemplos.spring.controller.EventController;
import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.repository.EventRepository;
import com.ejemplos.spring.service.EventServiceImpl;

@SpringBootTest
public class LucaTicketTest01_AddingEvents {
	
	private static final Logger log = Logger.getLogger("LucaTicketEventosApplicationTests.class");
	
	@Autowired
	EventRepository repo;

	@MockBean
	EventServiceImpl servi;
	
	@Autowired
	EventController control;

	@Test
	void contextLoads() {
	/**
	* Comprobación de que la prueba se carga correctamente *
	*/
	assertThat(true).isTrue();
	}

	@Test
	void testVerifyDataBase() {
		
	log.info("Validar conexión con la Base de Datos");
	log.info(""+repo.findAll());
	
	}

	@Test
	public void testAddEvent() {
		
	log.info("-------------------------- Iniciando test");
	Event e1 = new Event();
	
	String id = "1111";
	String name = "Evento1";
	String shortDescription ="Music";
	String longDescription ="Music Event";
	String image ="image";
	@SuppressWarnings("deprecation")
	Date date = new Date("2022/02/01");
	String hour = "12:30:00";
	int minimumprice = 3;
	int maximumprice = 15;
	String access = "sin condiciones";
	String locationname = "locationname";
	String locationcity = "locationcity";
	String locationaddress = "locationaddress";
	int locationcapacity = 15000;
	String genre = "Country";

	e1.setId(id);
	e1.setName(name);
	e1.setShortDescription(shortDescription);
	e1.setLongDescription(longDescription);
	e1.setImage(image);
	e1.setDate(date);
	e1.setHour(hour);
	e1.setMaximumprice(minimumprice);
	e1.setMinimumprice(maximumprice);
	e1.setAccess(access);
	e1.setLocationname(locationname);
	e1.setLocationcity(locationcity);
	e1.setLocationaddress(locationaddress);
	e1.setLocationcapacity(locationcapacity);
	e1.setGenre(genre);
	
	Event e2 = repo.save(e1);
	log.info("--------------------------"+e2);
	when(servi.save(e1)).thenReturn(e2);
	assertThat(e1).isEqualTo(e2);
	}
	
	@Test
	public void testAddedEvent() {
		
		Event e1 = new Event();
		
		String id = "1111";
		String name = "Evento1";
		String shortDescription ="Music";
		String longDescription ="Music Event";
		String image ="image";
		@SuppressWarnings("deprecation")
		Date date = new Date("2022/02/01");
		String hour = "12:30:00";
		int minimumprice = 3;
		int maximumprice = 15;
		String access = "sin condiciones";
		String locationname = "locationname";
		String locationcity = "locationcity";
		String locationaddress = "locationaddress";
		int locationcapacity = 15000;
		String genre = "Country";

		e1.setId(id);
		e1.setName(name);
		e1.setShortDescription(shortDescription);
		e1.setLongDescription(longDescription);
		e1.setImage(image);
		e1.setDate(date);
		e1.setHour(hour);
		e1.setMaximumprice(minimumprice);
		e1.setMinimumprice(maximumprice);
		e1.setAccess(access);
		e1.setLocationname(locationname);
		e1.setLocationcity(locationcity);
		e1.setLocationaddress(locationaddress);
		e1.setLocationcapacity(locationcapacity);
		e1.setGenre(genre);
		
		List<Event> list = repo.findAll();
		repo.save(e1);
		List<Event> lst = repo.findAll();
		assertThat(list.size()-1).isNotEqualTo(lst.size());
	}

}

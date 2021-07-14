package com.ejemplos.spring;
/**
 * @author: Ana Díaz, Rebeca Martínez, Rocío Jiménez, Sara Sevillano, Ana Ramírez*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.repository.EventRepository;
import com.ejemplos.spring.service.EventService;

@SpringBootTest
public class LucaTicketTest02_ListingEvents {

	@Autowired
	EventRepository repo;
	
	@Mock
	EventService servi;
	
	@Test
	public void listEvents() {
		List<Event> lst = repo.findAll();
		assertNotEquals(lst.size(),0);
	}
	
	@Test
	public void listEventsByName() {
		String name = "Juergas Rock Festival";
		List<Event> lst = repo.findByName(name);
		Iterator<Event> it = lst.iterator();
		while (it.hasNext()) {
            Event clave = it.next();
            assertEquals(clave.getName(),name);
		}	
	}
	
	@Test
	public void listEventsByGenre() {
		String genre = "Rock";
		List<Event> lst = repo.findByGenre(genre);
		Iterator<Event> it = lst.iterator();
		while (it.hasNext()) {
            Event clave = it.next();
            assertEquals(clave.getGenre(),genre);
		}	
	}
	
	@Test
	public void listEventsByCity() {
		String city = "Adra";
		List<Event> lst = repo.findByLocationcity(city);
		Iterator<Event> it = lst.iterator();
		while (it.hasNext()) {
            Event clave = it.next();
            assertEquals(clave.getLocationcity(),city);
		}	
	}
	
	@Test
	public void testfindById() {
		assertNotNull(servi.findById(""));
		verify(servi, times(1)).findById("");
	}
}

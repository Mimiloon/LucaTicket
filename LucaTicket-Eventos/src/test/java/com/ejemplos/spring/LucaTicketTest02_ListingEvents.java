package com.ejemplos.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
		
		assertNotNull(servi.findById(e1.getId()));
		verify(servi, times(1)).findById(e1.getId());
	}
}

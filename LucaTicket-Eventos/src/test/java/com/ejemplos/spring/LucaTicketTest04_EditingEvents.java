package com.ejemplos.spring;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.repository.EventRepository;

@SpringBootTest
public class LucaTicketTest04_EditingEvents {

	@Mock
	EventRepository repo;
	
	@Test
	public void testEditEvents() {
		
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
		
		repo.save(e1);
		e1.setImage("changedimage");
		Event e2 = repo.save(e1);
		assertThat(e1).isNotEqualTo(e2);
		
	}
}

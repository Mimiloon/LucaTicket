package com.ejemplos.spring;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.repository.EventRepository;

@SpringBootTest
public class LucaTicketTest02_ListingEvents {

	@Autowired
	EventRepository repo;
	
	@Test
	public void listEvents() {
		List<Event> lst = repo.findAll();
		assertNotEquals(lst.size(),0);
	}
}

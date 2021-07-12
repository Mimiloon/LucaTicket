package com.ejemplos.spring.service;
/**
* Class name: EventService.java
* Date: 07/07/2021
* @version: 2.0
* @author: Ana Díaz Muñoz*/
import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Event;

public interface EventService {
	
	// Return all events
	public List<Event> findAll();

	// Find the event by its id
	public Optional<Event> findById(String id);

	// Save a new event & update
	public Event save(Event event);

	// Delete event by its ID
	public void deleteById(String id);
	
	// List events by genre
	public List<Event> findByGenre(String genre);

	//List events by city
	public List<Event> findByCity(String city);
	
	//List events by name
	public List<Event> findByName(String name);

}

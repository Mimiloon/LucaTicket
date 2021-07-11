package com.ejemplos.spring.service;
/**
 * @author Ana Díaz Muñoz */
import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Event;

public interface EventService {
	
	// Return all events
	public List<Event> findAll();

	// Find the event with this id
	public Optional<Event> findById(String id);

	// Save a new event & update
	public Event save(Event event);

	// Delete event with this id
	public void deleteById(String id);

}

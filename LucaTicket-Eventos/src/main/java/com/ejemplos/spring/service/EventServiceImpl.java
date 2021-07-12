package com.ejemplos.spring.service;
/**
* Class name: EventServiceImpl.java
* Date: 10/07/2021
* @version: 2.0
* @author: Ana Díaz Muñoz*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository repository;

	@Override
	public List<Event> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Event> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Event save(Event event) {
		return repository.save(event);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<Event> findByGenre(String genre) {
		return repository.findByGenre(genre);
	}

	@Override
	public List<Event> findByCity(String city) {
		return repository.findByLocationcity(city);
	}
	
	@Override
	public List<Event> findByName(String name) {
		return repository.findByName(name);
	}
}

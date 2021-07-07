package com.ejemplos.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventRepository repo;
	
	@GetMapping
	public Collection<Event> listEvents(){
		return repo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event event){
		Event result = this.repo.save(event);
		return ResponseEntity.ok(result);
	}
}

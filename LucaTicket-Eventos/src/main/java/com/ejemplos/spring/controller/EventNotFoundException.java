package com.ejemplos.spring.controller;
/**
 * @author Ana Díaz Muñoz*/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 10L;

	public EventNotFoundException() {
		super("Epic Fail: The requested event doesn´t exist");
		action1();
	}
	public EventNotFoundException(Long id) {
		super("Epic Fail: The event with ID: "+id+" doesn´t exist");
	}	
	public void action1() {
		
	}
}

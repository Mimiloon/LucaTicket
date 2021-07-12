package com.ejemplos.spring.controller;
/**
* Class name: EventNotFoundException.java
* Date: 10/07/2021
* @version: 2.0
* @author: Ana Díaz Muñoz*/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 10L;

	public EventNotFoundException() {
		super("Epic Fail: The requested event doesn´t exist");
		action1();
	}
	public EventNotFoundException(String id) {
		super("Epic Fail: The event with ID: "+id+" doesn´t exist");
	}	
	public void action1() {
		
	}	
}

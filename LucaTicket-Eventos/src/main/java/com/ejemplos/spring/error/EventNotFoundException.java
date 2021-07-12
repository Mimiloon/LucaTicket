package com.ejemplos.spring.error;

public class EventNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 10L;

	public EventNotFoundException(String message) {
        super(message);
    }
}

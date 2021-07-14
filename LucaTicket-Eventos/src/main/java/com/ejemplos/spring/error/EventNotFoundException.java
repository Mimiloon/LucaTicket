package com.ejemplos.spring.error;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
public class EventNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 10L;

	public EventNotFoundException(String message) {
        super(message);
    }
}

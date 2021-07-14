package com.ejemplos.spring.error;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
public class IDNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public IDNotFoundException(String message) {
        super(message);
    }

	
}

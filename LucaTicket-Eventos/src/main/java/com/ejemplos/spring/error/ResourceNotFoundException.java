package com.ejemplos.spring.error;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3724733716325746713L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}

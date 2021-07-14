package com.ejemplos.spring.error;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
public class CityNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException(String message) {
        super(message);
    }
}

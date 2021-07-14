package com.ejemplos.spring.error;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
public class GenreNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public GenreNotFoundException(String message) {
        super(message);
    }
}

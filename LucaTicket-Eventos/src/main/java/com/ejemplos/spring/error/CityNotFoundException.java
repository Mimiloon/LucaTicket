package com.ejemplos.spring.error;

public class CityNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException(String message) {
        super(message);
    }
}

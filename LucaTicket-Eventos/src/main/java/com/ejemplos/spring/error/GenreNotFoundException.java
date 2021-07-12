package com.ejemplos.spring.error;

public class GenreNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public GenreNotFoundException(String message) {
        super(message);
    }
}

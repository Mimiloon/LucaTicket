package com.ejemplos.spring.error;

public class IDNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public IDNotFoundException(String message) {
        super(message);
    }

	
}

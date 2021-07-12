package com.ejemplos.spring.error;

public class NameNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public NameNotFoundException(String message) {
        super(message);
    }

}

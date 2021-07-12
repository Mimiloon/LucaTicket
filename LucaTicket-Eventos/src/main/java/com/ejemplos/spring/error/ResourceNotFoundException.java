package com.ejemplos.spring.error;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3724733716325746713L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}

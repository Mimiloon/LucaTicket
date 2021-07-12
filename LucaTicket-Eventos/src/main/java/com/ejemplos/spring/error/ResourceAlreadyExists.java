package com.ejemplos.spring.error;

public class ResourceAlreadyExists extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExists(String message) {
        super(message);
    }
}

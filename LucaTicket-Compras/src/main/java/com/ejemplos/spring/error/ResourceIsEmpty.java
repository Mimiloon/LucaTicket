package com.ejemplos.spring.error;

public class ResourceIsEmpty extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceIsEmpty(String message) {
        super(message);
    }
}

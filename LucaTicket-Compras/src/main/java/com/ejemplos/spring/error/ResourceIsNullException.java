package com.ejemplos.spring.error;

public class ResourceIsNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceIsNullException(String message) {
        super(message);
    }
}

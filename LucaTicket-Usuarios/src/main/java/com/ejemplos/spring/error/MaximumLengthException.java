package com.ejemplos.spring.error;

public class MaximumLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MaximumLengthException(String message) {
        super(message);
    }
}

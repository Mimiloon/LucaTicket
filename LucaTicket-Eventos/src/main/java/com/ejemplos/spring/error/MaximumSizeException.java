package com.ejemplos.spring.error;

public class MaximumSizeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MaximumSizeException(String message) {
        super(message);
    }
}

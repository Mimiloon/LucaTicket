package com.ejemplos.spring.error;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String message) {
        super(message);
    }
}

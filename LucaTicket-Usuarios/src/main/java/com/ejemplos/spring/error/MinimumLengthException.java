package com.ejemplos.spring.error;

public class MinimumLengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MinimumLengthException(String message) {
        super(message);
    }

}

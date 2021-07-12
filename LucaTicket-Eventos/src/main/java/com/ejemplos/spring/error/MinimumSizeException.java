package com.ejemplos.spring.error;

public class MinimumSizeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MinimumSizeException(String message) {
        super(message);
    }

}

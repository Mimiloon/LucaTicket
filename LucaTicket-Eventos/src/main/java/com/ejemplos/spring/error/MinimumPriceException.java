package com.ejemplos.spring.error;

public class MinimumPriceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MinimumPriceException(String message) {
        super(message);
    }
}

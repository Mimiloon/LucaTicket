package com.ejemplos.spring.error;

public class IDAlreadyExists extends ResourceAlreadyExists {

	private static final long serialVersionUID = 1L;

	public IDAlreadyExists(String message) {
        super(message);
    }
}

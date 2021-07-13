package com.ejemplos.spring.error;

public class DNIAlreadyExists extends ResourceAlreadyExists {

	private static final long serialVersionUID = 1L;

	public DNIAlreadyExists(String message) {
        super(message);
    }
}

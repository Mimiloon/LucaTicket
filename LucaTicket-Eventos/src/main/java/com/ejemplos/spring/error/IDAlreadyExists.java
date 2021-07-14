package com.ejemplos.spring.error;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
public class IDAlreadyExists extends ResourceAlreadyExists {

	private static final long serialVersionUID = 1L;

	public IDAlreadyExists(String message) {
        super(message);
    }
}

package com.ejemplos.spring.error;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
public class ResourceIsEmpty extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceIsEmpty(String message) {
        super(message);
    }
}

package com.ejemplos.spring.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3724733716325746713L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}

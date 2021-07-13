package com.ejemplos.spring.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DNINotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public DNINotFoundException(String message) {
        super(message);
    }

	
}

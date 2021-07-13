package com.ejemplos.spring.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 10L;

	public UserNotFoundException() {
		super("Epic Fail: No existe el usuario");
	}
	public UserNotFoundException(String dni) {
		super("Epic Fail: No existe el usuario "+ dni);
	}	
}

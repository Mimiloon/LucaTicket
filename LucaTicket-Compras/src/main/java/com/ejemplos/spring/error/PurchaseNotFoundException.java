package com.ejemplos.spring.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PurchaseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 10L;

	public PurchaseNotFoundException() {
		super("Epic Fail: The requested event doesn´t exist");
	}
	public PurchaseNotFoundException(String id) {
		super("Epic Fail: The event with ID: "+id+" doesn´t exist");
	}
}

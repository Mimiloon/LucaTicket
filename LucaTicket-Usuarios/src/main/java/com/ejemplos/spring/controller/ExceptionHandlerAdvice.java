package com.ejemplos.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ejemplos.spring.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleException(UserNotFoundException e) {
		// log exception
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
	}
	
}

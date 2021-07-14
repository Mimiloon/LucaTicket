package com.ejemplos.spring.error;
/**
 * @author Ana Díaz, Rebeca Martínez, Ana Ramírez, Sara Sevillano, Rocío Jiménez
 * */
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ejemplos.spring.model.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Crea una excepción personalizada a partir de una excepción ResourceNotFound
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFound(ResourceNotFoundException ex) {
		ErrorMessage response = new ErrorMessage(); // Crea un objeto de nuestro mensaje personalizado
		response.setErrorCode("NOT_FOUND");// Mete el código de error
		response.setErrorMessage(ex.getMessage());// Mete el nombre del error
		response.setTimestamp(LocalDateTime.now());// Pone fecha y hora en la que ocurre

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND); // Devuelve el mensaje personalizado
	}

	@ExceptionHandler(ResourceAlreadyExists.class)
	public ResponseEntity<ErrorMessage> resourceAlreadyExists(ResourceAlreadyExists ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(MinimumSizeException.class)
	public ResponseEntity<ErrorMessage> minimumSizeException(MinimumSizeException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(MaximumSizeException.class)
	public ResponseEntity<ErrorMessage> maximumSizeException(MaximumSizeException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(MinimumPriceException.class)
	public ResponseEntity<ErrorMessage> minimumPriceException(MinimumPriceException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceIsNullException.class)
	public ResponseEntity<ErrorMessage> resourceIsNullException(ResourceIsNullException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(IDAlreadyExists.class)
	public ResponseEntity<ErrorMessage> idAlreadyExists(IDAlreadyExists ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceIsEmpty.class)
	public ResponseEntity<ErrorMessage> resourceIsEmpty(ResourceIsEmpty ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorMessage> customException(CustomException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorMessage> unauthorizedException(UnauthorizedException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("UNAUTHORIZED");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<ErrorMessage> cityNotFound(CityNotFoundException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<ErrorMessage> nameNotFound(NameNotFoundException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler(GenreNotFoundException.class)
	public ResponseEntity<ErrorMessage> genreNotFound(GenreNotFoundException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<ErrorMessage> idNotFound(IDNotFoundException ex) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
	}
	
		@ExceptionHandler(EventNotFoundException.class)
		public ResponseEntity<ErrorMessage> eventNotFound(EventNotFoundException ex) {
			ErrorMessage response = new ErrorMessage();
			response.setErrorCode("NOT_FOUND");
			response.setErrorMessage(ex.getMessage());
			response.setTimestamp(LocalDateTime.now());

			return new ResponseEntity<ErrorMessage>(response, HttpStatus.NOT_FOUND);
		}
	
	

}

package com.ejemplos.spring.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ejemplos.spring.error.UserNotFoundException;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger LOG = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService serv;

	// Localizar usuario por ID

	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
	@GetMapping("/{dni}")
	public User readUser(@PathVariable String dni) {
		LOG.info("ENTRANDO A readUser(): dni:{}", dni);

		User result = serv.findByDNI(dni).orElseThrow(UserNotFoundException::new);

		LOG.info("SALIENDO de readUser(): {}", result);
		return result;
	}

	// Añadir usuario
	@PostMapping
	public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
		LOG.info("ENTRANDO A addUser(): {}", user);

		this.serv.addUser(user).orElseThrow(UserNotFoundException::new);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{dni}").buildAndExpand(user.getDni())
				.toUri();

		ResponseEntity<?> result = ResponseEntity.created(location).build();

		LOG.info("SALIENDO DE addUser()");
		return result;
	}

	// Actualizar un usuario
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
	@PutMapping("/{dni}")
	public User updateUser(@PathVariable String dni, @Valid @RequestBody User user) {
		LOG.info("ENTRANDO A updateUser(): dni:{}, user:{}", dni, user);

		User result = this.serv.updateUser(dni, user).orElseThrow(UserNotFoundException::new);

		LOG.info("SALIENDO DE updateUser(): {}", result);
		return result;
	}

	// Borrar un usuario
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{dni}")
	public void deleteUser(@PathVariable String dni) {
		serv.deleteUserByDNI(dni);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}

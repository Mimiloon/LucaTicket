package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<User> findAllUsers() {
		LOG.info("ENTRANDO A findAllUsers()");

		List<User> resultado = repo.findAll();

		LOG.info("SALIENDO DE findAllUsers(): {}", resultado);
		return resultado;
	}

	@Override
	public Optional<User> findByDNI(String dni) {
		LOG.info("ENTRANDO A findByDNI(): dni:{}", dni);

		Optional<User> resultado = repo.findById(dni);

		LOG.info("ENTRANDO A findByDNI(): {}", resultado);
		return resultado;

	}

	@Override
	public Optional<User> addUser(User user) {
		LOG.info("ENTRANDO A updateUser(): user:{}", user);

		// Encriptar la contrase�a antes de insertarla con el encoder inyectado
		String passwordOrigin = user.getPassword();
		String newPassword = encoder.encode(passwordOrigin);
		user.setPassword(newPassword);

		// Realizar el registro
		User result = repo.save(user);

		Optional<User> resultado = Optional.ofNullable(result);
		LOG.info("SALIENDO DE findAllUsers(): {}", resultado);
		return resultado;

	}

	@Override
	public User saveUser(User user) {
		LOG.info("ENTRANDO A updateUser(): user:{}", user);

		// Encriptar la contrase�a antes de insertarla con el encoder inyectado
		String passwordOrigin = user.getPassword();
		String newPassword = encoder.encode(passwordOrigin);
		user.setPassword(newPassword);

		// Realizar el registro
		User resultado = repo.save(user);

		LOG.info("SALIENDO DE findAllUsers(): {}", resultado);
		return resultado;

	}

	
	@Override
	public Optional<User> updateUser(String dni, User user) {
		LOG.info("ENTRANDO A updateUser(): dni:{}, user:{}", dni, user);

		// Tratar de encontrar al usuario con el dni del par�metro
		User userOld = findByDNI(dni).orElse(null);

		// Si no se localiza devolver un optional null
		if (userOld == null)
			return Optional.ofNullable(null);

		// Reestablecer la fecha de registro para no perderla durante el update
		user.setRegistration(userOld.getRegistration());

		// Encriptar la contrase�a antes de insertarla con el encoder inyectado
		user.setPassword(encoder.encode(user.getPassword()));

		User result = repo.save(user);
		Optional<User> resultado = Optional.ofNullable(result);

		LOG.info("SALIENDO DE updateUser(): {}", resultado);
		return resultado;
	}

	@Override
	public void deleteUserByDNI(String dni) {
		LOG.info("ENTRANDO A deleteUserByDNI(): dni:{}", dni);

		repo.deleteById(dni);

		LOG.info("SALIENDO DE deleteUserByDNI()");
	}

}

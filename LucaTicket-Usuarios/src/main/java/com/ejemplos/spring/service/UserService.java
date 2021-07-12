package com.ejemplos.spring.service;

import com.ejemplos.spring.model.User;
import java.util.List;
import java.util.Optional;


public interface UserService {

	// Return all users
	public List<User> findAllUsers();
	
	// Find the users with this dni
	public Optional<User> findByDNI(String dni);
	

	// Save a new user & update
	public Optional <User> addUser(User user);
	
	public Optional <User> updateUser(String dni, User user);
	

	// Delete user with this dni
	public void deleteUserByDNI(String dni);

	User saveUser(User user);

}

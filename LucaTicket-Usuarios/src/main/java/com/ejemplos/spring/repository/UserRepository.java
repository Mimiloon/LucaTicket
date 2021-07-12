package com.ejemplos.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u where dni = ?1 and password = ?2")
	Optional<User> login(String dni, String password);

}
package com.ejemplos.spring.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.exceptions.UserNotFoundException;
import com.ejemplos.spring.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOG = LogManager.getLogger(LoginController.class);

	@Autowired
	private LoginService serv;

	@PostMapping
	public String loginToken(@RequestParam("dni") String dni, @RequestParam("password") String pwd) {
		LOG.info("ENTRANDO EN loginToken(): dni:{}, pwd:{}", dni, pwd);

		String token = serv.login(dni, pwd);
		Optional.ofNullable(token)
			.orElseThrow(UserNotFoundException::new);

		LOG.info("SALIENDO DE loginToken(): {}", token);
		return token;
	}

}

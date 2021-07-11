package com.ejemplos.spring.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Role;
import com.ejemplos.spring.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginServiceImpl implements LoginService{
	
	private static final Logger LOG = LogManager.getLogger(LoginServiceImpl.class);
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserService serv;
	
	@Value("${token.secretKey}")
	String tokenSecretKey;

	@Value("${token.minutes}")
	Integer tokenMinutes;

	@Override
	public String login(String dni, String password) {
		LOG.info("ENTRANDO EN login(): dni:{}, pwd:{}", dni, password);

		// Tratar de localizar el usuario por DNI
		Optional<User> user = serv.findByDNI(dni);

		/*
		 * Verificar si el password introducido como par�metro coincide su hash con el
		 * encriptado en base de datos con el m�todo match del encoder. Si no coinciden entonces las contrase�as no son iguales
		 */
		if (user.orElse(null) == null) {
			return null;
		} else if (user.get().getPassword() == null) {
			return null;
		} else if (!encoder.matches(password, user.get().getPassword())) {
			return null;
		}
		
// 		Se podría escribir también así para simplificar
//		if (! encoder.matches(password, user.map(User::getPassword).orElse("")))
//			return null;

		String token = generarJWTToken(user.get());
		
		LOG.info("SALIENDO DE login(): {}", token);
		return token;
	}
	
	/*
	 * El m�todo generarJWTToken(...) se usa para construir el token, 
	 * delegando en la clase de utilidad Jwts que incluye informaci�n sobre su expiraci�n 
	 * y un objeto de GrantedAuthority de Spring.
	 * Este objeto lo usaremos para autorizar las peticiones a los recursos protegidos.
	 *  
	 */
	private String generarJWTToken(User user) {
		String role = Optional.ofNullable(user).map(User::getRole).map(Role::getRole).orElse("");
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(role);
		//String secretKey = "mySecretKey";
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(user.getDni())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (100000 * tokenMinutes)))
				.signWith(SignatureAlgorithm.HS512,
						tokenSecretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	


}

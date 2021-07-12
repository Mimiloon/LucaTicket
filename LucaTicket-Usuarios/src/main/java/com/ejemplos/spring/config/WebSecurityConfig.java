package com.ejemplos.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ejemplos.spring.security.JWTAuthorization;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * se permiten todas las llamadas al controlador /user, pero el resto de las
	 * llamadas requieren autenticación.
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				// Añadir filtrado de token requerido
				.addFilterAfter(new JWTAuthorization(), UsernamePasswordAuthenticationFilter.class)
				// Solicitar acceso
				.authorizeRequests()
		
				//Permitir todas las entradas por defecto (las restricciones se hacen en los controladores por rol)...
				.antMatchers("/**").permitAll();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
			//Añadir filtrado de token requerido
			.addFilterAfter(new JWTAuthorization(), UsernamePasswordAuthenticationFilter.class)
			//Permitir todas las entradas por defecto...
			.authorizeRequests()
			.antMatchers("/.*").permitAll()
			.and()
			//Excepto las siguientes rutas:
			.authorizeRequests()
			//impedir El update del usuario sin token
			.antMatchers(HttpMethod.PUT, "/users").authenticated()
			//impedir cualquier otra request de user sin token
			.antMatchers("/users/.*").authenticated()
			//impedir acceder a gretting
			.antMatchers("/greeting").authenticated();
			
	}
	*/
}

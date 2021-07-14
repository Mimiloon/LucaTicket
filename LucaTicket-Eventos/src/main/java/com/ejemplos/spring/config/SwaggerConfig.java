package com.ejemplos.spring.config;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .apiInfo(apiInfo())
	      .select()
	      .apis(RequestHandlerSelectors.any())
	      .paths(PathSelectors.any())
	      .build();
	}
	//http://localhost:2222/swagger-ui/
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "REST API Eventos",
	      "API encargada de registrar eventos, buscar por id, actualizar y eliminar, además de filtrar por varios parámetros.",
	      "1.0",
	      "Terms of service",
	      new Contact("Rebeca Mart�nez, Sara Sevillano, Ana D�az, Rocio Jim�nez, Ana M� Ram�rez", "www.lucaticket.com", "info@lucatiket.com"),
	      "License of API",
	      "API license URL",
	      Collections.emptyList());
	}

	

}

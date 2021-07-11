package com.ejemplos.spring.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Nombre Clase: User.java
* Descripcion: Clase User que contendrá la información de los usuarios del sistema de venta de tickets
* Fecha: 07/07/2021
* Version: 1.0
* Autor: Rocio Jimenez Moreno **/

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {

// ----------------------
// Atributos
// ----------------------

	/**
	 * Identificador del usuario
	 */
	@Id
	@NotNull(message = "dni no puede ser null")
    @NotBlank(message = "dni no puede estar vacío")
	@Length(max = 11, min = 8, message = "El DNI debe tener entre 8 y 11 caraceres")
	private String dni;

	/**
	 * Nombre del usuario
	 */
	@ApiModelProperty(example = "Pepe")
	@NotNull(message = "name no puede ser null")
    @NotBlank(message = "name no puede estar vacío")
	private String name;

	/**
	 * Apellidos del usuario
	 */
	@ApiModelProperty(example = "Culata")
	private String surname;

	/**
	 * Email del usuario
	 */
	@NotNull(message = "email no puede ser null")
    @NotBlank(message = "email no puede estar vacío")
	private String email;

	/**
	 * Password del usuario
	 */
//@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull(message = "password no puede ser null")
    @NotBlank(message = "password no puede estar vacío")
	private String password;

	/**
	 * Fecha de alta del registro de usuario
	 */
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(required = false, hidden = true)
	private Date registration;

	/**
	 * 
	 * token
	 */
	@ApiModelProperty(required = false, hidden = true)
	private String token;

	/**
	 * 
	 * enabled
	 */

	private Boolean enabled;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role;

//----------------------
// Constructor
//----------------------

	public User(String dni, String name, String surname, String email, String password, Role role) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public User(String dni, String name, String surname, String email, String password) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		}
}

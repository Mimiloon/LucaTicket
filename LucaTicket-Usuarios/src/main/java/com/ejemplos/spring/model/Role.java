package com.ejemplos.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")

public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(example = "2")
	private Long id;
	@ApiModelProperty(example = "ROLE_USER")
	private String role;

}

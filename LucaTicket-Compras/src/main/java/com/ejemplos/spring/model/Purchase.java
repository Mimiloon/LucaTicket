package com.ejemplos.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
* Class name: Purchase.java
* Description: Java Class which contains data related to the purchases from the database
* Date: 12/07/2021
* Version: 2.0
* Author: Ana M. Ramírez**/

@Document(collection = "Purchases")
@Data
public class Purchase implements Serializable {

	private static final long serialVersionUID = -4299885995482111879L;
	
	
	@Id
	@ApiModelProperty(required = false, hidden = true)
	private String id;
	@Field()
	@NotEmpty
	private String dni;
	@Field()
	@NotEmpty
	private String eventId;
	@Field()
	@ApiModelProperty(required = false, hidden = true)
	private Date datePurchase;
	@Field
	@NotEmpty
	@Size(min = 1)
	private Integer amount;
	@Field
	@NotEmpty
	private Double price;
	@Field
	@ApiModelProperty(required = false, hidden = true)
	private Double totalPrice;
	@Field
	@NotEmpty
	private String type;
	@Field
	private boolean isPaid;
	
	
	
	
}

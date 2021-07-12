package com.ejemplos.spring.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
* Class name: Event.java
* Description: Java Class which contains data related to the events from the database
* Date: 07/07/2021
* Version: 2.0
* Author: Ana Díaz Muñoz**/

@Document(collection = "Events")
@Data
public class Event implements Serializable {

	private static final long serialVersionUID = 2330258799651251994L;

	@Id
	private String id;
	@Field()
	@NotEmpty
	private String name;
	@Field()
	@Size(min=1, max = 15)
	private String shortDescription;
	@Field()
	@Size(min=8, max = 30)
	private String longDescription;
	@Field()
	private String image;
	@Field()
	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd") 
	private Date date;
	@Field()
	@NotEmpty
	@JsonFormat(pattern = "HH:mm:ss")
	private String hour;
	@Field()
	@NotNull
	@Min(0)
	private int minimumprice;
	@Field()
	@Min(0)
	private int maximumprice;
	@Field()
	private String access;
	@Field()
	@NotEmpty
	private String locationname;
	@Field()
	@NotEmpty
	private String locationcity;
	@Field()
	@NotEmpty
	private String locationaddress;
	@Field()
	@NotEmpty
	private int locationcapacity;
	@Field()
	@NotEmpty
	private String genre;
	
	
}

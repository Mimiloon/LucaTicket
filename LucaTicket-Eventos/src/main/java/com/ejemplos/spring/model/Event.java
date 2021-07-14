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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @author: Ana Díaz, Ana Ramírez, Rocío Jiménez, Sara Sevillano, Rebeca Martínez*/

@Document(collection = "Events")
@Data
public class Event implements Serializable {

	private static final long serialVersionUID = 2330258799651251994L;

	@Id
	@ApiModelProperty(required=false, hidden = true)
	private String id;
	@Field()
	@NotEmpty
	private String name;
	@Field()
	@Size(min=1, max = 50)
	private String shortDescription;
	@Field()
	@Size(min=8, max = 200)
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
	@NotNull
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
	
	//Constructor de prueba
	public Event(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Event() {
		
	}
	
}

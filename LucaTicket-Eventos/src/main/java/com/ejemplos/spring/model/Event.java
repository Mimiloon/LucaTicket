package com.ejemplos.spring.model;

import java.time.LocalTime;
import java.util.Date;


import org.springframework.data.annotation.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Document(collection = "event")
@Data
public class Event {

	@Id
	private Long id;
	@NotEmpty
	private String name;
	@Size(min=2, max = 5)
	private String shortDescription;
	@Size(min=6, max = 30)
	private String longDescription;
	private String image;
	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd") 
	private Date date;
	@NotEmpty
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hour;
	@NotNull
	@Min(5)
	@Max(200)
	private int price;
	private String access;
	@NotEmpty
	private Location location;
	
	
}

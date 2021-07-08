package com.ejemplos.spring.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Document(collection = "Events")
@Data
public class Event implements Serializable {

	private static final long serialVersionUID = 2330258799651251994L;
	
	@Id
	private String id;
	@NotEmpty
	private String name;
	@Size(min=1, max = 15)
	private String shortDescription;
	@Size(min=8, max = 30)
	private String longDescription;
	private String image;
	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd") 
	private Date date;
	@NotEmpty
	@JsonFormat(pattern = "HH:mm:ss")
	private String hour;
	@NotNull
	@Min(0)
	private int minimumprice;
	@Min(0)
	private int maximumprice;
	private String access;
	@NotEmpty
	private Location location;
	@NotEmpty
	private String genre;
	
	
}

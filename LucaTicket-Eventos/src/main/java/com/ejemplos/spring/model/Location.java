package com.ejemplos.spring.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document
@Data
public class Location {
	
		private String name;
		private String place;
		private String direction;
		private int capacity;
}

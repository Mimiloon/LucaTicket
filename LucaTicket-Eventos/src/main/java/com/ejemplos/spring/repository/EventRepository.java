package com.ejemplos.spring.repository;
/**
* Class name: EventRepository.java
* Date: 10/07/2021
* @version: 2.0
* @author: Ana Díaz Muñoz*/


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ejemplos.spring.model.Event;

@Repository
public interface EventRepository extends MongoRepository <Event, String> {

	List<Event> findByGenre(String genre);

	List<Event> findByLocationcity(String locationcity);
	
	List<Event> findByName(String name);
	
}

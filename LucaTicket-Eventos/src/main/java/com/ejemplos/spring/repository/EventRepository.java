package com.ejemplos.spring.repository;
/**
 * @author: Ana Díaz, Rebeca Martínez, Ana Ramírez, Rocío Jiménez, Sara Sevillano*/


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

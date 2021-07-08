package com.ejemplos.spring.repository;
/**
 * @author Ana Díaz Muñoz*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ejemplos.spring.model.Event;

@Repository
public interface EventRepository extends MongoRepository <Event, String>{
	
}

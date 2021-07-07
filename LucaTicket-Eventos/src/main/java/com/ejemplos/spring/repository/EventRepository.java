package com.ejemplos.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ejemplos.spring.model.Event;
public interface EventRepository extends MongoRepository <Event, Long>{

}

package com.ejemplos.spring.repository;
/**
* Class name: PurchaseRepository.java
* Date: 10/07/2021
* @version: 2.0
* @author: Ana M. Ramírez*/


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Purchase;

@Repository
public interface PurchaseRepository extends MongoRepository <Purchase, String> {
	
}

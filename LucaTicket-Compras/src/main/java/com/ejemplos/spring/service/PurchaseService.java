package com.ejemplos.spring.service;
/**
* Class name: PurchaseService.java
* Date: 07/07/2021
* @version: 2.0
* @author: Ana M. Ramírez*/
import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Purchase;


public interface PurchaseService {
	
	// Return all purchases
	public List<Purchase> findAll();

	// Find the purchase by its id
	public Optional<Purchase> findById(String id);
	
	// Save a new purchase & update
	public Purchase save(Purchase purchase, String token);

	// Delete purchase by its ID
	public void deleteById(String id);

	//Check if user exists
	Boolean userExists(String dni, String token);

	//Check if event exists
	Boolean eventExists(String eventId);
	
	

}

package com.ejemplos.spring.controller;
/**
* Class name: PurchaseController.java
* Description: Java Class which contains the methods and the endpoints
* Date: 10/07/2021
* @version: 1.0
* @author: Ana M. Ramírez*/

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ejemplos.spring.model.Purchase;
import com.ejemplos.spring.service.PurchaseService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
	
	@Autowired
	private PurchaseService service;
	
	
	//Find purchase by ID
	@GetMapping(value = "/{id}")
	public Purchase readPurchase(@PathVariable String id) {
		System.out.println("-------- readPurchase");
		return service.findById(id)
				   .orElseThrow(PurchaseNotFoundException::new);
	}
	
	//Add purchase
	@PostMapping
	public ResponseEntity<?> addEvent(Purchase purchase, @RequestHeader (name="Authorization") String token) {
	Purchase result = this.service.save(purchase, token);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
	.toUri();

	return ResponseEntity.created(location).build();
	}
	



	
	
}
package com.ejemplos.spring.service;
import java.util.Date;
/**
* Class name: PurchaseServiceImpl.java
* Date: 10/07/2021
* @version: 2.0
* @author: Ana M. Ramírez*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.Purchase;
import com.ejemplos.spring.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository repository;

	@Override
	public List<Purchase> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Purchase> findById(String id) {
		return repository.findById(id);
	}
	
	@Override
	// Aquí estamos conectando el microservicio de usuarios con el de compras, estamos 
	// comprobando si el usuario existe y pasándole el token porque requiere autenticación
	public Boolean userExists(String dni, String token){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:3333/users/"+ dni, HttpMethod.GET, entity, String.class);
		return response.getStatusCode().equals(HttpStatus.OK);
	}
	
	@Override
	public Boolean eventExists(String eventId){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:2222/events/"+ eventId, String.class);
		return response.getStatusCode().equals(HttpStatus.OK);
	}

	@Override
	public Purchase save(Purchase purchase, String token) {
		if(userExists(purchase.getDni(), token) && eventExists(purchase.getEventId())) {
			Double total = purchase.getAmount() * purchase.getPrice();
			purchase.setTotalPrice(total);
			purchase.setDatePurchase(new Date());
			return repository.save(purchase);
		}
		return null;
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	

	
}

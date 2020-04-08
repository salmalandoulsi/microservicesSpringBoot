package com.altran.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController_RestTemplate {

	

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/products")
	public String getProducts() {

		return this.restTemplate.getForObject("http://localhost:9090/products/products", String.class);
	}

}

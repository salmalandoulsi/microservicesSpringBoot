package com.altran.order.productClient;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/* 
 * Modele de l'entité Product du microservice ProductService
 * 
 * */

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("price")
	private Float price;

	public Product(Long id, String name, Float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getPrice() {
		return price;
	}
}

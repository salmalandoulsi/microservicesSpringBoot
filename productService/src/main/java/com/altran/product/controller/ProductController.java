package com.altran.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.altran.product.entities.Product;
import com.altran.product.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = "/exemple", method = RequestMethod.GET)
	public String ExempleProduit() {
		return "un exemple de produit";
	}

	@PostMapping(value = "/addProduct")
	public void addProduct(@Valid @RequestBody Product product) {

		productRepository.save(product);

	}
	@GetMapping(value = "/products")
	public Iterable<Product> getProducts()
	{	//return Iterable
		return productRepository.findAll();
	}
	
	@GetMapping(path ="/{idProduct}")
	public Product getProductByID(@PathVariable Long idProduct)
	{
		//findById return Optional
		return  productRepository.findById(idProduct).get();
	}
	
	
	
	@PutMapping(path ="/{idProduct}" )
	public void updateProduct(@PathVariable Long idProduct)
	{
		Product produt=getProductByID(idProduct);
		System.out.println(produt.getName());
		produt.setPrice(200f);
		productRepository.save(produt);
		
	}
	
	@PutMapping(value = "/update/{idProduct}" )
	public void updateProduct(@PathVariable Long idProduct ,@RequestBody Product newproduct)
	{
		Product product=getProductByID(idProduct);
		product=newproduct;
		product.setId(idProduct);
		productRepository.save(product);
		
	}
	
	@DeleteMapping(value="/delete/{idProduct}")
	public String deleteProduct(@PathVariable Long idProduct)
	{
		productRepository.delete(getProductByID(idProduct));
		return "ok";
		
	}

}

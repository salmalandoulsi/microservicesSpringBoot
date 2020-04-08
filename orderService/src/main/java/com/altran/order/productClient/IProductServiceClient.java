package com.altran.order.productClient;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "product-service", url = "http://localhost:9090/products")
public interface IProductServiceClient {

	@GetMapping(value = "/products") // le nom de cet endpoint est le meme que dans le service
										// productServiceController
	public List<Product> getAllProducts();

	@GetMapping(value = "/product/{idProduct}")
	public Product getProduct(@PathVariable("idProduct") Long idProduct);
	
	@PutMapping(value="/update/{idProduct}")
	public void updateProduct(@PathVariable("idProduct") Long idProduct, @RequestBody Product newproduct);

	@PostMapping(value = "/addProduct")
	public void addProduct(@Valid @RequestBody Product product); 

	@GetMapping("/product1/{id}")
	 public ResponseEntity < ? > getProsucts1(@PathVariable Long id) ;
	
	@DeleteMapping(value = "/delete/{idProduct}")
	public String deleteProduct(@PathVariable Long idProduct);


}

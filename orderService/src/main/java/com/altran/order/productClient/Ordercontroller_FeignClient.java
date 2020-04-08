package com.altran.order.productClient;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ordercontroller_FeignClient {

	@Autowired
	IProductServiceClient iProductServiceClient;

	@GetMapping(value = "/fetchProducts")
	public ResponseEntity<?> fetchAllProducts() {
		
		return ResponseEntity.ok(iProductServiceClient.getAllProducts());
	}

	@GetMapping(value = "/fetchProduct/{idProduct}")
	public ResponseEntity<?> fetchProduct(@PathVariable Long idProduct) {
		return ResponseEntity.ok(iProductServiceClient.getProduct(idProduct));
	}

	@PostMapping(value = "/addProduct")
	public void addProduct(@Valid @RequestBody Product product) {

		iProductServiceClient.addProduct(product);

	}

	@PutMapping(value = "/update/{idProduct}")
	public void updateProduct(@PathVariable("idProduct") Long idProduct, @RequestBody Product newproduct) {
		iProductServiceClient.updateProduct(idProduct, newproduct);
	}

	

	@DeleteMapping(value = "/delete/{idProduct}")
	public String deleteProduct(@PathVariable Long idProduct) {
		return iProductServiceClient.deleteProduct(idProduct);
		

	}
}
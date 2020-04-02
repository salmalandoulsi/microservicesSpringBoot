package com.altran.product.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.altran.product.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}


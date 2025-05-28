package com.web_api.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.web_api.crud.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}

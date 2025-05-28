package com.web_api.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.web_api.crud.model.User;

public interface UserRepository extends MongoRepository<User, String>{
    
}

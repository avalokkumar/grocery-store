package com.claycorp.nexstore.api.v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.claycorp.nexstore.api.v1.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
package com.mgo.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mgo.project.domain.Account;
import com.mgo.project.domain.UserModel;

public interface AccountRepository extends MongoRepository<Account, String>{
	public UserModel findByUsername(String username);
	
}

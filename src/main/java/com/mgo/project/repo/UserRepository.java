package com.mgo.project.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mgo.project.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
	public List<User> findByCity(String city);
	
	public List<User> findAll();
	
	//Page findAll(Pageable pageable);
}

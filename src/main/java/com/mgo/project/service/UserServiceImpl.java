package com.mgo.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mgo.project.domain.User;
import com.mgo.project.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository repository;
	@Autowired
	public
	UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

	@Override
	public User create(User user) {
		User created = repository.save(user);
		return created;
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public List<User> findByCity(String city) {
		return repository.findByCity(city);
	}

   
}

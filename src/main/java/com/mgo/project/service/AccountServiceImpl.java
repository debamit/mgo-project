package com.mgo.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgo.project.domain.Account;
import com.mgo.project.domain.UserModel;
import com.mgo.project.repo.AccountRepository;
import com.mgo.project.repo.UserRepository;
@Service
public class AccountServiceImpl implements AccountService {
	private AccountRepository repository;
	@Autowired
	AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

	@Override
	public UserModel verify(String userName) {
		return repository.findByUsername(userName);
	}

}

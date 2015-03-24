package com.mgo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mgo.project.domain.Account;
import com.mgo.project.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	private  AccountService accountService;
	
	@Autowired
	AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
	
//	@RequestMapping(method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.CREATED)
//	HttpStatus verifyAccount(@RequestParam (value="user", required = true)String user,
//			@RequestParam (value="password", required = false)String password){
//		Account acc =  accountService.verify(user);
//		if(acc.getPassword().equalsIgnoreCase(password)){
//			return HttpStatus.OK;
//		} else{
//			return HttpStatus.FORBIDDEN;
//		}
//	}
}

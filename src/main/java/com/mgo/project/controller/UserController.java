package com.mgo.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgo.project.domain.User;
import com.mgo.project.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private  UserService userService;
	
	@Autowired
	public
	UserController(UserService userService) {
        this.userService = userService;
    }

//	@RequestMapping(method = RequestMethod.GET)
//	List<User> findAllUsers(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
//            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
//            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
//            @RequestParam(value = "sort", defaultValue = "productName", required = false) String sortProperty){
//		Page result = userService.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
//		return result.getContent();
//	}
	

	@RequestMapping(method = RequestMethod.GET)
	List<User> findAll(){
		return userService.findAll();
	}
	


	@RequestMapping(value="/filter",method = RequestMethod.GET)
	List<User> findUsersByCity(@RequestParam (value="city", required = true)String city){
		List<User> users = userService.findByCity(city);
		return users;
	}
		
	@RequestMapping(value="/create",method = RequestMethod.POST)
	User createUser(@RequestBody @Valid User user)
			{
		return userService.create(user);
	}
	
}

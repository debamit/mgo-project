package com.mgo.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mgo.project.repo.StatusRepository;

@RestController
@RequestMapping("/status")
public class StatusController {
private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private  StatusRepository  repo;
	
	@Autowired
	StatusController(StatusRepository repo) {
        this.repo = repo;
    }
	
	@RequestMapping(method = RequestMethod.GET)
	String checkSatus(){
		try {
			if(repo.checkStatus()){
				return "Mongo db is up";
			}
		}
		catch(Exception ex){
			return ex.getMessage();
		}
		return "Mongo Status";
		
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(StatusException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}

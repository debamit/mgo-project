package com.mgo.project.controller;

public class StatusException extends RuntimeException{
	 public StatusException(String status) {
	        super(String.format("Mongo db is down: <%s>", status));
	    }
}

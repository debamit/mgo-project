package com.mgo.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatusRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	
	public boolean checkStatus()
	{
		if(mongoTemplate.collectionExists("user")){
			return true;
		}
		else{
			return false;
		}
	}


}

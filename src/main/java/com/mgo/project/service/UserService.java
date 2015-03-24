package com.mgo.project.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.mgo.project.domain.User;

public interface UserService {
	 /**
     * Creates a new user entry.
     * @param user  The information of the created user entry.
     * @return      The information of the created user entry.
     */
	public User create(User user) ;

    /**
     * Finds all user entries.
     * @return      The information of all user entries.
     */
    List<User> findAll();
    

    /**
     * Finds a single user entry.
     * @param city    The id of the requested user entry.
     * @return      List of users .
     */
    List<User> findByCity(String city);
    
}

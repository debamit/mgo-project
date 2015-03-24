package com.mgo.project.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.mgo.project.domain.User;

public interface UserService {
	 /**
     * Creates a new todo entry.
     * @param todo  The information of the created todo entry.
     * @return      The information of the created todo entry.
     */
	public User create(User user) ;

    /**
     * Finds all todo entries.
     * @return      The information of all todo entries.
     */
    List<User> findAll();
    
//    /**
//     * Finds all todo entries.
//     * @return      The information of all todo entries.
//     */
//    List<User> findAllPaged(PageRequest pageRequest);

    /**
     * Finds a single todo entry.
     * @param id    The id of the requested todo entry.
     * @return      The information of the requested todo entry.
     * @throws com.javaadvent.bootrest.todo.TodoNotFoundException if no todo entry is found.
     */
    List<User> findByCity(String city);
    
    //List<User>findByCityGroupedByProf(String city , String prof);


}

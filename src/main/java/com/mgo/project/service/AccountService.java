package com.mgo.project.service;

import java.util.List;

import com.mgo.project.domain.Account;
import com.mgo.project.domain.User;
import com.mgo.project.domain.UserModel;


public interface AccountService {
    /**
     * Creates a new UserModel entry.
     * @param userModel  The information to create the account.
     * @return      The information of the created account.
     */
	UserModel create(UserModel userModel);
    
    /**
     * Creates a new UserModel entry.
     * @param userName  The information to create the account.
     * @return      The information of the created account.
     */
	UserModel verify(String userName);

}

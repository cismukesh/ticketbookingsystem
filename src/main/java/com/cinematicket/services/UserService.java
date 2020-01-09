package com.cinematicket.services;

import java.util.Optional;

import com.cinematicket.entities.User;

public interface UserService {

   /**
    * save / update user 
    * @param user
    * @return User Object
    */
	User saveUser(User user);
	
	/**
	 * fetch user by id
	 * @param id
	 * @return User Object
	 */
	Optional<User> getUserById(Long id);	
	
	/**
	 * for get user by check username password 
	 * @param email
	 * @param password
	 * @return User Object
	 */
	User getUserByEmailPassword(String email,String password);
	
	/**
	 * for encrypt password
	 * @param password
	 * @return
	 */
	String encryptPassword(String password);
	
}

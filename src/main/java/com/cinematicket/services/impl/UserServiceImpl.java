 /**
 * 
 */
package com.cinematicket.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinematicket.entities.User;
import com.cinematicket.repository.UserRepository;
import com.cinematicket.services.UserService;

/**
 * @author cis
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User getUserByEmailPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public String encryptPassword(String password) {
		return userRepository.encryptPassword(password);
	}

}

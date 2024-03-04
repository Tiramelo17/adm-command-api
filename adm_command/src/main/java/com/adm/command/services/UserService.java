package com.adm.command.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.adm.command.models.User;
import com.adm.command.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder encoder;
	
	public User findByUserNameAndPassword(String userName, String password) {
		return userRepository.findUserByUserNameAndPassword(userName, password);
	}
	
	@Transactional
	public User createUser(User user) {
        String pass = user.getPassword();
		user.setPassword(encoder.encode(pass));
		return userRepository.save(user);
	}
	
	
	public User findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}
}

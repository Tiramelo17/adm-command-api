package com.adm.command.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adm.command.appService.UserAppService;
import com.adm.command.config.security.objects.Sessao;
import com.adm.command.models.User;

@RestController
public class UserController {
	
	
	@Autowired
	UserAppService userAppService;

	
	@GetMapping("/login")
	public Sessao  loginUser(@RequestBody User user) {
		return userAppService.loginUser(user.getUserName(), user.getPassword());
	}
	
	
	@PostMapping("/login/create")
	public User createLogin(@RequestBody User user) {
		return userAppService.createUser(user);
	}
}

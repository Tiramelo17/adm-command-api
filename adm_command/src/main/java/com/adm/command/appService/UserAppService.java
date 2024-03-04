package com.adm.command.appService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.adm.command.Handler.BusinessException;
import com.adm.command.config.security.JWTCreator;
import com.adm.command.config.security.JWTObject;
import com.adm.command.config.security.SecurityConfig;
import com.adm.command.config.security.objects.Sessao;
import com.adm.command.models.User;
import com.adm.command.services.UserService;

@Component
public class UserAppService {

	 @Autowired
	 private PasswordEncoder encoder;
	 
	 @Autowired
	 private SecurityConfig securityConfig;
	
	@Autowired
	UserService userService;
	
	public Sessao loginUser(String userName, String password) {
		try {
			User user = findByUsername(userName);
			if(user!=null) {
			    boolean passwordOk =  encoder.matches(password, user.getPassword());
			    if (!passwordOk) {
			        throw new BusinessException("Senha inválida para o login: " + userName);
			  }
			}
			 Sessao sessao = new Sessao();
			 sessao.setLogin(user.getUserName());

			 JWTObject jwtObject = new JWTObject();
			 jwtObject.setSubject(user.getUserName());
			 jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
			 jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
			 jwtObject.setRoles(user.getRoles());
			 sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
			    
			return sessao;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	public User findByUsername(String userName) {
		return userService.findByUsername(userName);
	}
	
	public User createUser(User user) {
		try {
			return userService.createUser(user);			
		} catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	public User masckUser(User user) {
		String userName = user.getUserName();
		user = new User(userName);
		return user;
	}
}

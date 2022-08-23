package com.barclays.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.demospring.model.User;
import com.barclays.demospring.repo.UserRepo;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/auth/login")
	public void login(String username, String password) {
		
		System.out.println(username + " " + password);
	}
	
	@PostMapping("/auth/register")
	public void register(int loginID, String password) {
	
		User user = new User();
		
		user.setLoginID(loginID);
		user.setPassword(password);
		user.setRoleID(1);
		
		userRepo.save(user);
		System.out.println(loginID + " " + password);
	}
}

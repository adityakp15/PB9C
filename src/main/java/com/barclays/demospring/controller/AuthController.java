package com.barclays.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.demospring.model.User;
import com.barclays.demospring.repo.UserRepo;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/login")
	public ResponseEntity<String> login(int loginID, String password) {
		
		User user  = userRepo.findById(loginID).orElse(new User());
		int role = 0;
		
		if(user.getLoginID() == loginID && user.getPassword().equals(password)) {
			
			role = user.getRoleID();
			
			String body = "{roleID: " + role + "}";
			
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Invalid Credentials", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(User user) {
		
		//already exists
		if(userRepo.existsById(user.getLoginID())) {
			
			return new ResponseEntity<>("User exists", HttpStatus.BAD_REQUEST);
		}
		
		//invalid role
		if(user.getRoleID() < 1 || user.getRoleID() > 3) {
			
			return new ResponseEntity<>("Invalid Role", HttpStatus.BAD_REQUEST);
		}
		
		//password length
		if(user.getPassword().length() < 6) {
			
			return new ResponseEntity<>("Password length should be greater than 6 characters", HttpStatus.BAD_REQUEST);
		}
		
		User afterReg = userRepo.save(user);
		return new ResponseEntity<>(afterReg.toString(), HttpStatus.OK);
	}
}

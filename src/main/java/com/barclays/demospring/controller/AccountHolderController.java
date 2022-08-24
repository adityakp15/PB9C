package com.barclays.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.demospring.model.User;
import com.barclays.demospring.repo.UserRepo;

@RestController
public class AccountHolderController {
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/acc/{loginID}")
	public ResponseEntity<String> getUser(@PathVariable int loginID){
		if(!userRepo.existsById(loginID)) {
			return new ResponseEntity<> ("User does not exist",HttpStatus.BAD_REQUEST);
		}
		
		User user = userRepo.findById(loginID).orElse(new User());
		
		return new ResponseEntity<> (user.toString(),HttpStatus.OK);
		
	}
	
	
	
}

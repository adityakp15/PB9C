package com.barclays.demospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.demospring.model.Accounts;
import com.barclays.demospring.model.User;
import com.barclays.demospring.repo.AccountsRepo;
import com.barclays.demospring.repo.UserRepo;

@RestController
public class AccountHolderController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AccountsRepo accRepo;
	
//	@GetMapping("/acc/{loginID}/bills")
//	public ResponseEntity<String> getBills(@PathVariable int loginID) {
//		
//		
//	}
	
	@GetMapping("/acc/{loginID}")
	public ResponseEntity<String> getUser(@PathVariable int loginID){
		if(!userRepo.existsById(loginID)) {
			return new ResponseEntity<> ("User does not exist",HttpStatus.BAD_REQUEST);
		}

		User user = userRepo.findById(loginID).orElse(new User());

		return new ResponseEntity<> (user.toString(),HttpStatus.OK);

	}
	
	@GetMapping("/acc/{loginID}/accounts")
	public ResponseEntity<String> getAccounts(@PathVariable int loginID) {
		
		if(!userRepo.existsById(loginID)) {
			
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		
		int seq = userRepo.findById(loginID).orElse(new User()).getSequenceID();
		
		List<Accounts> acc = (List<Accounts>) accRepo.findBySequenceID(seq);
		
		return new ResponseEntity<>(acc.toString(), HttpStatus.OK);
	}
	
	@PostMapping("/acc/{loginID}/newaccount")
	public ResponseEntity<String> newAccount(@PathVariable int loginID ,@RequestBody Accounts account) {
		
		if(!userRepo.existsById(loginID)) {
			
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		
		int seq = userRepo.findById(loginID).orElse(new User()).getSequenceID();
		
		account.setSequenceID(seq);
		account.setCurrentBalance(2000);
		
		return new ResponseEntity<>(accRepo.save(account).toString(), HttpStatus.OK);
	}
}

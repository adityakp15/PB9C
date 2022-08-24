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
	
	@GetMapping("/acc/{loginID}/accounts")
	public ResponseEntity<List<Accounts>> getAccounts() {
		
		List<Accounts> acc = (List<Accounts>) accRepo.findAll();
		
		return new ResponseEntity<>(acc, HttpStatus.OK);
	}
	
	@GetMapping("/acc/{loginID}/consumernumbers")
	public ResponseEntity<List<ConsumerNumber>> getConsumerNumbers(@Path)
	
	@PostMapping("/acc/{loginID}/newaccount")
	public ResponseEntity<Accounts> newAccount(@RequestBody Accounts account) {
		
		return new ResponseEntity<>(accRepo.save(account), HttpStatus.OK);
	}
}

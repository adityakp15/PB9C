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
import com.barclays.demospring.model.Bill;
import com.barclays.demospring.model.ConsumerNumber;
import com.barclays.demospring.model.RegisteredBiller;
import com.barclays.demospring.model.User;
import com.barclays.demospring.repo.AccountsRepo;
import com.barclays.demospring.repo.BillRepo;
import com.barclays.demospring.repo.ConsumerNumberRepo;
import com.barclays.demospring.repo.RegisteredBillerRepo;
import com.barclays.demospring.repo.UserRepo;

@RestController
public class AccountHolderController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AccountsRepo accRepo;
	
	@Autowired
	private ConsumerNumberRepo consRepo;
	
	@Autowired
	private BillRepo billRepo;
	
	@Autowired
	private RegisteredBillerRepo regBillRepo;
	
//	@GetMapping("/acc/{loginID}/bills")
//	public ResponseEntity<String> getBills(@PathVariable int loginID) {
//		
//		
//	}

	@GetMapping("acc/{loginID}/consumernumbers")
	public ResponseEntity<String> getConsumerNumbers(@PathVariable int loginID) {
		
		if(!userRepo.existsById(loginID)) {
			return new ResponseEntity<> ("User does not exist", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<> (consRepo.findByLoginID(loginID).toString(), HttpStatus.OK);
	}
	
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
	
	@PostMapping("acc/{loginID}/consumernumber")
	public ResponseEntity<String> addConsumerNumber(@PathVariable int loginID, String cno) {
		
		if(!userRepo.existsById(loginID)) {
			
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		if(cno == null) {
			
			return new ResponseEntity<>("Invalid Consumer ID", HttpStatus.NOT_FOUND);
		}
		
		ConsumerNumber cnumber = new ConsumerNumber();
		cnumber.setCno(cno);
		cnumber.setLoginID(loginID);
		
		consRepo.save(cnumber);
		
		return new ResponseEntity<>("Successful", HttpStatus.OK);
	}
	
	@PostMapping("acc/{loginID}/bills/register")
	public ResponseEntity<String> registerBill(@RequestBody RegisteredBiller biller, @PathVariable int loginID){
		
		if(!userRepo.existsById(loginID)) {
			
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		
		if(!billRepo.existsBybCodeAndConsumerNumber(biller.getbCode(), biller.getcNumber())) {
			
			return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
		}		
		
		//insert in register
		regBillRepo.save(biller);
		
		return new ResponseEntity<>("Registered", HttpStatus.OK);
	}
	
	@PostMapping("acc/{loginID}/bills/{bn}/{cn}/toggleautopay")
	public ResponseEntity<String> toggleAutoPay(@PathVariable int loginID, @PathVariable String bn, @PathVariable String cn) {
		
		if(!userRepo.existsById(loginID)) {
			
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		
		if(!billRepo.existsBybCodeAndConsumerNumber(bn, cn)) {
			
			return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
		}		
		
		RegisteredBiller biller = regBillRepo.fingBybCodeAndcNumber(bn, cn).orElse(new RegisteredBiller());
		
		
		biller.setaP(!biller.isaP());

		return new ResponseEntity<>("Successfull, AutoPay: " + biller.isaP(), HttpStatus.OK);
	}
	
	@PostMapping("acc/{loginID}/bills/{bn}/{cn}/setautopaylimit")
	public ResponseEntity<String> setApLimit(@PathVariable int loginID, @PathVariable String bn, @PathVariable String cn, int apLimit) {
		
		if(!userRepo.existsById(loginID)) {
			
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		
		if(!billRepo.existsBybCodeAndConsumerNumber(bn, cn)) {
			
			return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
		}		
		
		RegisteredBiller biller = regBillRepo.fingBybCodeAndcNumber(bn, cn).orElse(new RegisteredBiller());
		
		
		biller.setaPLimit(apLimit);

		return new ResponseEntity<>("Successfull, AutoPayLimit: " + biller.getaPLimit(), HttpStatus.OK);
	}
}

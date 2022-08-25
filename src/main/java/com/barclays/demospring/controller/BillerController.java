package com.barclays.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.demospring.model.RequestedBill;
import com.barclays.demospring.repo.BillerRepo;
import com.barclays.demospring.repo.RequestedBillsRepo;

@RestController
public class BillerController {
	@Autowired
	private BillerRepo billerRepo;
	
	@Autowired
	private RequestedBillsRepo requestedBillsRepo;
	
	@PostMapping("billers")
	@ResponseBody
	public ResponseEntity<String> getBillers(){
		String body = billerRepo.findAll().toString();
		
		return new ResponseEntity<>(body, HttpStatus.OK);

	}
	@GetMapping("biller/{id}")
	public ResponseEntity<String> BillerHome(@PathVariable("id") String id){
		String body = "Hello "+id;
		return new ResponseEntity<>(body, HttpStatus.OK);	
	}
	
	@PostMapping("biller/{bid}/req")
	public ResponseEntity<String> BillerRequest(@PathVariable("bid") String id, @RequestBody RequestedBill rb){
		rb.setStatus("pending");
		rb.setbCode(id);
		requestedBillsRepo.save(rb);
		
//		String body = "biller_code : "+id+", consumer_number : 1122, due_date : 24/08/2022, amount : 300";
		return new ResponseEntity<>(rb.toString(), HttpStatus.OK);
	}
	
//	@PostMapping("biller/{bid}/reqs")
//	public String Billerredirect(@PathVariable("bid") String id){
//		
//		String body = "biller_code : "+id+", consumer_number : 1122, due_date : 24/08/2022, amount : 300";
//		return "redirect:/auth/biller/1";
//	}
}

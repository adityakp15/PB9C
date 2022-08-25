package com.barclays.demospring.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.barclays.demospring.model.Bill;
import com.barclays.demospring.model.RequestedBill;
import com.barclays.demospring.repo.BillerRepo;
import com.barclays.demospring.repo.ManagerRepo;
import com.barclays.demospring.repo.RequestedBillsRepo;


import java.util.List;

@RestController
public class ManagerController {

  @Autowired
   private ManagerRepo managerrepo;
  @Autowired 
  private RequestedBillsRepo requestedBillsRepo;
	

  @GetMapping("manager/assign")
  public String managerhome()
  {
	  
	    
	  
	  List<RequestedBill> l=requestedBillsRepo.findAll();
	  
	  int length=l.size();
	  
	  
	  for(int i=0;i<length;i++)
	  {
		 
		  if(l.get(i).getStatus().equals("pending"))
		  {
			  Bill b=new Bill();
			  b.setAmount(l.get(i).getAmount());
			  b.setBillerCode(l.get(i).getbCode())	;
			  b.setConsumerNumber(l.get(i).getCnumber());
			  b.setDueDate(l.get(i).getDueDate());
			  b.setStatus("Not Paid");
			  l.get(i).setStatus("Approved");
			 requestedBillsRepo.save(l.get(i));
			  managerrepo.save(b);  
		  }
		
	
	  }
	 return managerrepo.findAll().toString();
  }
  
  
	 
	 @GetMapping("manager")
	  public String managerdisplay()
	 {
		 
	   return requestedBillsRepo.findAll().toString();  
	
	 }
	
	
}

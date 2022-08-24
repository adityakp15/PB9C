package com.barclays.demospring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.RequestedBill;

public interface RequestedBillsRepo extends JpaRepository<RequestedBill, String>{

}

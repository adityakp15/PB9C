package com.barclays.demospring.repo;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.Bill;


public interface ManagerRepo extends CrudRepository<Bill, Integer> {
 
}


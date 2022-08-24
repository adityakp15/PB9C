package com.barclays.demospring.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.Bill;

public interface BillRepo extends CrudRepository<Bill, Integer> {
	
	boolean existsBybCodeAndConsumerNumber(String bCode, String consumerNumber);
	Optional<Bill> findBybCodeAndConsumerNumber(String bCode, String consumerNumber);
}

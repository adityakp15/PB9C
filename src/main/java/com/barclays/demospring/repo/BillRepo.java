package com.barclays.demospring.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.Bill;

public interface BillRepo extends CrudRepository<Bill, Integer> {
	
	boolean existsByBCodeAndConsumerNumber(String bcode, int consumerNumber);
//	Optional<Bill> findByBCodeAndConsumerNumber(String bcode, int consumerNumber);
}

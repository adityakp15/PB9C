package com.barclays.demospring.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.ConsumerNumber;

public interface ConsumerNumberRepo extends CrudRepository<ConsumerNumber, Integer> {

	List<ConsumerNumber> findByLoginID(int loginID);
}

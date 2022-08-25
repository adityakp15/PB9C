package com.barclays.demospring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.RegisteredBiller;



public interface RegisteredBillerRepo extends CrudRepository<RegisteredBiller, Integer>{
	
	List<RegisteredBiller> findByaP(Boolean ap);

	List<Object> findByaP(boolean ap);

	Optional<RegisteredBiller> fingBybCodeAndcNumber(String bCode, String cNumber);

}
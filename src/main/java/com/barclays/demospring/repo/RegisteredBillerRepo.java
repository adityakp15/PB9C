package com.barclays.demospring.repo;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.RegisteredBiller;

public interface RegisteredBillerRepo extends CrudRepository<RegisteredBiller, String>{

}
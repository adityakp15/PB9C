package com.barclays.demospring.repo;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.MasterBiller;

public interface BillerRepo extends CrudRepository<MasterBiller, String>{

}

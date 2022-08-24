package com.barclays.demospring.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.Accounts;

public interface AccountsRepo extends CrudRepository<Accounts, Integer> {

	List<Accounts> findBySequenceID(int sequenceID);
}

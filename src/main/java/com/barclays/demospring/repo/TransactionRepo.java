package com.barclays.demospring.repo;

import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.AccountTransaction;

public interface TransactionRepo extends CrudRepository<AccountTransaction, Integer>{

}

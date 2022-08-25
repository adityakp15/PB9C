package com.barclays.demospring.repo;

import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.barclays.demospring.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {
 
	Optional<User> findByloginID(int loginID);
	boolean existsByloginID(int loginID);
}

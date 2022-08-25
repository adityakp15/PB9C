package com.barclays.demospring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.barclays.demospring.model.User;
import com.barclays.demospring.repo.UserRepo;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DemoSpringApplicationTests {

	
	@Autowired
	UserRepo uRepo;
	
	@Test
	@Order(1)
	public void testCreate() {
		User user = new User();
		user.setLoginID(1);
		user.setPassword("password");
		user.setRoleID(1);
		uRepo.save(user);
		
		assertNotNull(uRepo.findById(1).get());	
		
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		List<User> list=(List<User>) uRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testUserRole(){
		User user= uRepo.findById(1).get();
		System.out.println(user.getRoleID());
		assertEquals(2, user.getRoleID());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		User user= uRepo.findById(1).get();
		user.setRoleID(2);
		uRepo.save(user);
		assertNotEquals(1, uRepo.findById(1).get().getRoleID());
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		uRepo.deleteById(1);
		assertThat(uRepo.existsById(1)).isFalse();
	}


}
package com.dalin.controller;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.mapper.UserMapper;
import com.dalin.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	UserController uc;
	
	@Autowired
	UserMapper mapper;
	
	@Test
	public void addUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setSalary(9999.0);
		user.setHeight(178);
		user.setName("dalin");
		user.setValidInd(true);
		
//		mapper.insert(user);
		uc.addUser(user);
	}
	
	
	
}

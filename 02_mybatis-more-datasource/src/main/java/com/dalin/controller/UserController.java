package com.dalin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalin.mapper.user1.User1Mapper;
import com.dalin.mapper.user2.User2Mapper;
import com.dalin.model.User;

@RestController
public class UserController {
	
	@Autowired
	User1Mapper mapper1;
	
	@Autowired
	User2Mapper mapper2;


	@RequestMapping("/getAll1")
	public List<User> getAll1(User user) {
		
		List<User> list =mapper1.getAll();
		
		return list;
	}
	
	@RequestMapping("/getAll2")
	public List<User> getAll2(User user) {
		
		List<User> list =mapper2.getAll();
		
		return list;
	}
	

}

package com.dalin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalin.mapper.UserMapper;
import com.dalin.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserMapper mapper;

	@RequestMapping("/add")
	public User addUser(User user) {
		
		try {
			mapper.add(user);			
		} catch (Exception e) {
			return null;
		}
		
		return user;
	}
	
	@RequestMapping("/getOne")
	public User getOne(int id) {
		User user = mapper.getById(id);
		return user;
	}
	
	@RequestMapping("/getList")
	public List<User> getList() {
		List<User> list = mapper.getAll();
		return list;
	}
}

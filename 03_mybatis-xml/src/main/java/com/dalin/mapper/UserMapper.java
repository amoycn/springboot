package com.dalin.mapper;

import java.util.List;

import com.dalin.model.User;

public interface UserMapper {

	User getById(int id);
	
	List<User> getAll();
	
	void add(User user);
	
	void updateSalary(User user);
	
	void deleteById(int id);
}

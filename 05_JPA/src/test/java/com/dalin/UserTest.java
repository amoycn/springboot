package com.dalin;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.model.User;
import com.dalin.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Resource
	private UserRepository ur;
	
	@Test
	public void addUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setHeight(178);
		user.setName("dalin");
		user.setSalary(12888.0);
		user.setSex("xiaohuozi");
		user.setValidInd(true);
		ur.save(user);
	}
	
	@Test
	public void getAll() {
		List<User> list = ur.findAll();
		System.err.println(list);
	}
	
}

package com.dalin;

import java.util.ArrayList;
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
	
//	@Test
//	public void addUser() {
//		User user = new User();
//		user.setBirthday(new Date());
//		user.setHeight(178);
//		user.setName("dalin");
//		user.setSalary(12888.0);
//		user.setSex("xiaohuozi");
//		user.setValidInd(true);
//		ur.save(user);
//	}
	
	@Test
	public void addMoreUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setHeight(178);
		user.setName("dalin");
		user.setSalary(12888.0);
		user.setSex("xiaohuozi");
		user.setValidInd(true);

		User user2 = new User();
		user2.setBirthday(new Date());
		user2.setHeight(178);
		user2.setName("dalin2");
		user2.setSalary(12888.0);
		user2.setSex("xiaohuozi2");
		user2.setValidInd(true);
		
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user2);
		
		ur.saveAll(list);
	}
	
	@Test
	public void getAll() {
		List<User> list = ur.findAll();
		System.err.println(list);
	}
	
}

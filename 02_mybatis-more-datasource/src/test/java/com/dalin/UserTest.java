package com.dalin;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.mapper.user1.User1Mapper;
import com.dalin.mapper.user2.User2Mapper;
import com.dalin.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private User1Mapper mapper1;
	
	@Autowired
	private User2Mapper mapper2;
	
	@Test
	public void test1() {
		List<User> list1 = mapper1.getAll();
		System.out.println(list1);
	}
	
	@Test
	public void test2() {
		List<User> list2 = mapper2.getAll();
		System.out.println(list2);
	}
	
	@Test
	public void test3() {
		mapper1.deleteById(4);
	}
	
	@Test
	public void test4() {
		User user = new User();
		user.setBirthday(new Date());
		user.setSalary(9999.0);
		mapper1.add(user);
	}

}

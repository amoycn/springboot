package com.dalin;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.model.User;
import com.dalin.service.UserConditionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserConditionTest {

	@Resource
	private UserConditionService ud;
	
//	@Test
//	public void find1() {
//		List<User> list = ud.find_one();
//		System.err.println(list);
//	}
//	
//	@Test
//	public void find2() {
//		List<User> list = ud.find_more();
//		for (User user : list) {
//			System.err.println(user);
//		}
//	}
	
	@Test
	public void find3() {
		List<User> list = ud.find_more2();
		for (User user : list) {
			System.err.println(user);
		}
	}
	
}

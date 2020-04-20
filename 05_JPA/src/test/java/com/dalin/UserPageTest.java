package com.dalin;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.model.User;
import com.dalin.service.UserPageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPageTest {

	@Resource
	private UserPageService ups;
	
	@Test
	public void getAll() {
		Page<User> page = ups.find_page();
		System.err.println(page);
		System.err.println("总数：" + page.getTotalElements());
		System.err.println("当前页：" + page.getPageable().getPageNumber());
		System.err.println("每页数量：" + page.getPageable().getPageSize());
		List<User> list = page.getContent();
		for (User user : list) {
			System.err.println(user);
		}
	}
	
}

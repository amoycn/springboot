package com.dalin.mapper.mybatis;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.model.MybatisUser;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisUserMapperTest {

	@Autowired
	private MybatisUserMapper mapper;
	
	@Test
	void add() {
		MybatisUser user = new MybatisUser();
		user.setName("admin");
		user.setBirthday(new Date());
		user.setSalary(12888.00);
		user.setSex("男");
		user.setHeight(178);
		user.setValidInd(true);
		mapper.insert(user);
	}
	
	@Test
	void getAll() {
		List<MybatisUser> list = mapper.getAll();
		System.out.println(list);
	}

}

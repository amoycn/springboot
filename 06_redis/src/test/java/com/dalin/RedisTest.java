package com.dalin;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.util.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisUtil util;
	
	/**
	 * String
	 */
	@Test
	public void test1() {
		util.set("mykey", "love");
		String value = (String) util.get("mykey");
		System.err.println(value);
	}
	
	/**
	 * List
	 */
	@Test
	public void test2() {
		List<String> list = new ArrayList<String>();
		list.add("my11");
		list.add("my21");
		list.add("my31");
		util.lSet("mykey3", list);
		List<Object> value = util.lGet("mykey3",0,9);
		for (Object object : value) {
			System.err.println(object);
		}
	}
	
}

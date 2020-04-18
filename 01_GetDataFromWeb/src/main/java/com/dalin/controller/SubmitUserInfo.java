package com.dalin.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalin.model.User;

@RestController
public class SubmitUserInfo {

	/**
	 * 字段名称一致直接获取
	 */
	@RequestMapping("/submit1")
	public User submit1(String name,Integer height,Double salary,Boolean validInd,Date birthday) {
		
		User user = new User();
		user.setBirthday(birthday);
		user.setHeight(height);
		user.setName(name);
		user.setSalary(salary);
		user.setValidInd(validInd);
		System.out.println("通过字段获取信息：" + user);
		
		return user;
	}
	
	/**
	 * 和对象属性名一致，直接赋值对象
	 */
	@RequestMapping("/submit2")
	public User submit2(User user) {
		
		System.out.println("直接用户对象提交：" + user);
		
		return user;
	}
	
	/**
	 * @PathVariable 获取URL路径中的占位符
	 * @RequestParam 获取请求参数中的参数
	 */
	@RequestMapping("/submit3/{ind}")
	public User submit3(@PathVariable(name = "ind",required = true) String myInd,
			@RequestParam(name = "ind",required = true,defaultValue = "demo-ind") String myname,
			Integer height,Double salary,Boolean validInd,Date birthday) {
		
		User user = new User();
		user.setBirthday(birthday);
		user.setHeight(height);
		user.setName(myname);
		user.setSalary(salary);
		user.setValidInd(validInd);
		System.out.println("URL的传值：" + myInd);
		System.out.println("通过字段获取信息：" + user);
		
		return user;
	}
}

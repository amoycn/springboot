package com.dalin.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private Integer id; //用户id
	private String name; //姓名
	private String sex; //性别
	private Integer height; //身高
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday; //生日
	private Double salary; //薪水
	private Boolean validInd; //是否有效
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Boolean getValidInd() {
		return validInd;
	}
	public void setValidInd(Boolean validInd) {
		this.validInd = validInd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "MybatisUser [id=" + id + ", name=" + name + ", sex=" + sex + ", height=" + height + ", birthday="
				+ birthday + ", salary=" + salary + ", validInd=" + validInd + "]";
	}
}

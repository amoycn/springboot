package com.dalin.mapper.user1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.dalin.model.User;

public interface User1Mapper {
	
	@Select("select * from user")
	List<User> getAll();

	@Select("select * from user where id = #{id}")
	@Results({
		@Result(property = "name", column = "name", javaType = String.class)
	})
	User getById(int id);
	
	@Insert("insert into user(id,name,sex,height,birthday,salary,validInd) "
			+ "values (#{id},#{name},#{sex},#{height},#{birthday},#{salary},#{validInd})")
	void add(User user);
	
	@Delete("delete from user where id = #{id}")
	void deleteById(int id);
	
	@Update("update user set salary = #{salary} where id = #{id}")
	void updateSalary(User user);
	
}

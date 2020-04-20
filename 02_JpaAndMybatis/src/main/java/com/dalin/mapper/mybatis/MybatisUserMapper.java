package com.dalin.mapper.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dalin.model.MybatisUser;


public interface MybatisUserMapper {

	@Insert("insert into user(id,name,sex,height,birthday,salary,validInd) "
			+ "values (#{id},#{name},#{sex},#{height},#{birthday},#{salary},#{validInd})")
	void insert(MybatisUser user);
	
	@Select("select * from user")
	List<MybatisUser> getAll();
	

	
	
	@Select("select * from user where id = #{id}")
	@Results({
		@Result(property = "name", column = "name", javaType = String.class)
	})
	MybatisUser getOne(int id);
	
	
	
	@Update("update user set remark = #{remark} where id = #{id}")
	void updateRemark(MybatisUser user);
	
	@Delete("delete from user where id = #{id}")
	void delete(int id);
	
}

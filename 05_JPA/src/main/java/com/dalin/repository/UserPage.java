package com.dalin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.dalin.model.User;

/**
 * 分页查询
 *
 */
public interface UserPage extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{

}

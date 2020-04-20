package com.dalin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.dalin.model.User;

/**
 * JpaSpecificationExecutor 需要 JpaRepository 配合使用
 *
 */
public interface UserCondition extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{

}

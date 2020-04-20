package com.dalin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalin.model.User;

/**
 * 只要继承JpaRepository即可实现大部分已经封装的方法
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}

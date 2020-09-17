package com.jasdhir.springdemo.hib.dao;

import java.util.List;

import com.jasdhir.springdemo.hib.model.User;

public interface UserDao {
	   void add(User user);
	   List<User> listUsers();
	   void update(Long id);
	}
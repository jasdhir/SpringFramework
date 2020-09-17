package com.jasdhir.springdemo.hib.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasdhir.springdemo.hib.dao.UserDao;
import com.jasdhir.springdemo.hib.model.User;

@Service
public class UserServiceImp implements UserService{
	 @Autowired
	   private UserDao userDao;
	 
	 @Transactional
	@Override
	public void add(User user) {
		  userDao.add(user);
		
	}

	 @Transactional
	@Override
	public List<User> listUsers() {
		 return userDao.listUsers();
	}

	@Transactional
	@Override
	public void update(Long id) {
		userDao.update(id);
	}
}

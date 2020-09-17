package com.jasdhir.springdemo.hib.service;

import java.util.List;

import com.jasdhir.springdemo.hib.model.User;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void update(Long id);
}

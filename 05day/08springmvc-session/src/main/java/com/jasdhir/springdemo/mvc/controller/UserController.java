package com.jasdhir.springdemo.mvc.controller;

import com.jasdhir.springdemo.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/user")
public class UserController {

    /*
     * Get user from session attribute
     */
    @GetMapping("/info")
    public String userInfo(@SessionAttribute("user") User user) {

        System.out.println("Email: " + user.getEmail());
        System.out.println("First Name: " + user.getFname());

        return "user";
    }
}

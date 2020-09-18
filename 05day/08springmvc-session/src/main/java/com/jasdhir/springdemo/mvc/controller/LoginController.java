package com.jasdhir.springdemo.mvc.controller;

import com.jasdhir.springdemo.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@SessionAttributes("user")
public class LoginController {
    /*
     * Add user in model attribute
     */
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model) {

        // Implement your business logic
        if (user.getEmail().equals("jasdhir@example.com") && user.getPassword().equals("abc@123")) {
            // Set user dummy data
            user.setFname("Jasdhir");
            user.setLname("Singh");
            user.setAge(42);

        } else {
            model.addAttribute("message", "Login failed. Try again.");
            return "index";
        }
        return "success";
    }
}

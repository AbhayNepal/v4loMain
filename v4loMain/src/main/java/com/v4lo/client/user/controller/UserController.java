package com.v4lo.client.user.controller;

import com.v4lo.client.user.entity.User;
import com.v4lo.client.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public void addUser(){
        User user = new User();
        user.setFirstName("arch");
        user.setLastName("che");
        user.setEmail("gmai.com");
        user.set2faEnabled(true);
        user.setFalseLoginAttempts(0);
        userRepository.saveAndFlush(user);
    }
}

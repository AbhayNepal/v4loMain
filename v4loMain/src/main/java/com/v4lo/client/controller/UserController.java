package com.v4lo.client.controller;

import com.v4lo.client.entity.User;
import com.v4lo.client.repository.UserRepository;
import com.v4lo.client.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestService testService;
    @RequestMapping(method = RequestMethod.GET,value = "/add")
    public void addUser(){
        User user = new User();
        user.setFirstName("arch");
        user.setLastName("che");
        user.setEmail("gmai.com");
        user.set2faEnabled(true);
        user.setFalseLoginAttempts(0);
        testService.testAddData();
    }
}

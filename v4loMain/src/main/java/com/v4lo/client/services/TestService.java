package com.v4lo.client.services;

import com.v4lo.client.entity.User;
import com.v4lo.client.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    UserRepository userRepository;
    Logger logger = Logger.getLogger(User.class);
    public void testAddData(){
        User user = new User();
        user.setEmail("abbay.nepal.8");
        user.set2faEnabled(true);
        user.setAccountLocked(false);
        user.setPhoneNumber("234343");
        user.setFirstName("abhay");
        user.setLastName("nepal");

        User saved= userRepository.save(user);
        logger.info("saved user" + saved.getFirstName());

    }
}

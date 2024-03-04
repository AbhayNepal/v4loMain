package com.v4lo.appuser.service;

import com.v4lo.appuser.Entity.Users;
import com.v4lo.appuser.SecurityUser;
import com.v4lo.appuser.repository.AppUserRepository;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    AppUserRepository appUserRepository;
    Logger logger = LoggerFactory.getLogger(AppUserService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(username).map(SecurityUser::new)
                .orElseThrow(() -> new
                        UsernameNotFoundException(String.format(
                        "username not found", username
                )));
    }

    public ResponseEntity<JSONObject> registerUser(Users user) {
        JSONObject jsonObjectResponse = new JSONObject();
        if (user != null) {
            if (appUserRepository.findByEmail(user.getEmail()).isPresent()) {
                jsonObjectResponse.put("Message", "Error");
                jsonObjectResponse.put("info", "user already exists for email " + user.getEmail().toString());
                logger.info("found registered email");
                return new ResponseEntity<>(jsonObjectResponse, HttpStatus.NOT_ACCEPTABLE);
            } else {
                Users returnedUser = appUserRepository.saveAndFlush(user);
                if (returnedUser != null) {
                    jsonObjectResponse.put("Message","Error");
                    jsonObjectResponse.put("info","failed to register user for email "+user.getEmail());
                    return new ResponseEntity<>(jsonObjectResponse,HttpStatus.INTERNAL_SERVER_ERROR);
                }
                jsonObjectResponse.put("Message","Error");
                jsonObjectResponse.put("info","user successfully registered.");
                return new ResponseEntity<>(jsonObjectResponse,HttpStatus.OK);
            }
        }
        jsonObjectResponse.put("Message","Error");
        jsonObjectResponse.put("info","empty response received");
        return new ResponseEntity<>(jsonObjectResponse,HttpStatus.BAD_REQUEST);
    }
}

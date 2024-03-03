package com.v4lo.security;

import com.v4lo.appuser.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration{
    @Autowired
    private AppUserService appUserService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth->auth.requestMatchers("/").permitAll()
                        .anyRequest().authenticated())
                .userDetailsService(appUserService).build();
    }

}

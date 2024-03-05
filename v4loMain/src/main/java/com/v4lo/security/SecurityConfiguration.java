package com.v4lo.security;
import com.v4lo.appuser.AppUserRole;
import com.v4lo.appuser.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
public class SecurityConfiguration{
    @Autowired
    private AppUserService appUserService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth-> auth.antMatchers("/home").permitAll()
                        .antMatchers("/user/**").hasAnyRole(AppUserRole.USER.getValue(),AppUserRole.ADMIN.getValue())
                        .antMatchers("/admin/**").hasRole(AppUserRole.USER.getValue())
                        .antMatchers("/register").permitAll()
                .anyRequest().authenticated())
                .userDetailsService(appUserService).formLogin().and()
                .build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

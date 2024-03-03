package com.v4lo.appuser.service;

import com.v4lo.appuser.SecurityUser;
import com.v4lo.appuser.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(username).map(SecurityUser::new)
                .orElseThrow(()->new
                        UsernameNotFoundException(String.format(
                                "username not found",username
                )));
    }
}

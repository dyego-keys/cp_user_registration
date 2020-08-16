package com.countiespower.api.user.register.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("diego".equals(username)) {
            return new User("diego","$2y$12$phFqLFpuNJsZ1ixqLqzRFuMUjA2S7RTqQwjfCYVJEcAzCrEDqHh9e", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}

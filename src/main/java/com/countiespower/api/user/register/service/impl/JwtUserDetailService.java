package com.countiespower.api.user.register.service.impl;

import com.countiespower.api.user.register.data.UserEntity;
import com.countiespower.api.user.register.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public JwtUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<UserEntity> userEntityOp = userRepository.findByEmailIgnoreCase(email);
        if (!userEntityOp.isPresent()) {
            throw new UsernameNotFoundException(email);
        }
        return new User(userEntityOp.get().getEmail(), userEntityOp.get().getEncryptedPassword(), true, true, true, true, new ArrayList<>());
    }
}

package com.countiespower.api.user.register.service.impl;

import com.countiespower.api.user.register.data.UserEntity;
import com.countiespower.api.user.register.data.UserRepository;
import com.countiespower.api.user.register.dto.UserDto;
import com.countiespower.api.user.register.service.UsersService;
import com.countiespower.api.user.register.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {

        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> usersDTO = MapperUtils.mapAll(userEntities, UserDto.class);
        return usersDTO;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        Optional<UserEntity> userEntityOp = userRepository.findByUserId(userId);
        if (!userEntityOp.isPresent()) {
            throw new RuntimeException("User not found with userId: "+userId);
        }
        return MapperUtils.map(userEntityOp.get(), UserDto.class);
    }
}

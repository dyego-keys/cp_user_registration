package com.countiespower.api.user.register.service.impl;

import com.countiespower.api.user.register.data.UserEntity;
import com.countiespower.api.user.register.data.UserRepository;
import com.countiespower.api.user.register.dto.UserDto;
import com.countiespower.api.user.register.service.UsersService;
import com.countiespower.api.user.register.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<UserDto> getUsers(Pageable paging) {
        Page<UserEntity> userEntities = userRepository.findAll(paging);
        Page<UserDto> userDtos = userEntities.map(new Function<UserEntity, UserDto>() {
            @Override
            public UserDto apply(UserEntity entity) {
                return MapperUtils.map(entity, UserDto.class);
            }
        });
        return userDtos;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        Optional<UserEntity> userEntityOp = userRepository.findByUserId(userId);
        if (!userEntityOp.isPresent()) {
            throw new RuntimeException("User not found with userId: " + userId);
        }
        return MapperUtils.map(userEntityOp.get(), UserDto.class);
    }

    @Override
    public Page<UserDto> getUserByLastName(String lastName, Pageable paging) {
        Page<UserEntity> userEntities = userRepository.findByLastNameIgnoreCase(lastName, paging);
        Page<UserDto> userDtos = userEntities.map(new Function<UserEntity, UserDto>() {
            @Override
            public UserDto apply(UserEntity entity) {
                return MapperUtils.map(entity, UserDto.class);
            }
        });
        return userDtos;
    }
}

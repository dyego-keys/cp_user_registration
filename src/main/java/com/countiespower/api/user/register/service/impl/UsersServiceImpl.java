package com.countiespower.api.user.register.service.impl;

import com.countiespower.api.user.register.data.UserEntity;
import com.countiespower.api.user.register.data.UserRepository;
import com.countiespower.api.user.register.dto.UserDto;
import com.countiespower.api.user.register.service.UsersService;
import com.countiespower.api.user.register.utils.MapperUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
public class UsersServiceImpl implements UsersService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

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

    @Override
    public UserDto createUser(UserDto userDto) {

        userDto.setUserId(UUID.randomUUID().toString());
        userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        ModelMapper mm  = new ModelMapper();
        mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = mm.map(userDto, UserEntity.class);

        UserEntity savedUserEntity = userRepository.save(userEntity);

        UserDto savedUserDto = mm.map(savedUserEntity, UserDto.class);
        return savedUserDto;
    }
}

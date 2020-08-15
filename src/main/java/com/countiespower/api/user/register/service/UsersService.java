package com.countiespower.api.user.register.service;

import com.countiespower.api.user.register.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    UserDto getUserByUserId(String userId);
}

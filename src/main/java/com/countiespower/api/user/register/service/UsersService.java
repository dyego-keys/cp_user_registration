package com.countiespower.api.user.register.service;

import com.countiespower.api.user.register.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsersService {
    Page<UserDto> getUsers(Pageable paging);
    UserDto getUserByUserId(String userId);
    Page<UserDto> getUserByLastName(String lastName, Pageable paging);
    UserDto createUser(UserDto userDto);
}

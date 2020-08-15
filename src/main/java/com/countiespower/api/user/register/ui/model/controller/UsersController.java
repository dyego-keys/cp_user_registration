package com.countiespower.api.user.register.ui.model.controller;

import com.countiespower.api.user.register.dto.UserDto;
import com.countiespower.api.user.register.service.UsersService;
import com.countiespower.api.user.register.ui.model.UserResponse;
import com.countiespower.api.user.register.utils.MapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    Environment env;

    @Autowired
    UsersService usersService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserDto> usersDto = usersService.getUsers();

        List<UserResponse> responseList = MapperUtils.mapAll(usersDto, UserResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping(value="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {

        UserDto userDto = usersService.getUserByUserId(userId);
        UserResponse returnValue = MapperUtils.map(userDto, UserResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    @GetMapping("/status/check")
    public String status()
    {
        return "Working on port " + env.getProperty("local.server.port");
    }

}

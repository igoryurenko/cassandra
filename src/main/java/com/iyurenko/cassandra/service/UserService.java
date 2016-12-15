package com.iyurenko.cassandra.service;

import com.iyurenko.cassandra.web.dto.UserDto;

/**
 * Created by iyurenko on 02.12.16.
 */
public interface UserService {

    void insertUser(UserDto userDto);

    void updateUser(UserDto userDto);

    UserDto getUserByLogin(String login);

    UserDto getUserByEmail(String email);


}

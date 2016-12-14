package com.iyurenko.cassandra.service;

import com.iyurenko.cassandra.web.dto.UserDto;

/**
 * Created by iyurenko on 02.12.16.
 */
public interface UserService {

    public void saveUser(UserDto userDto);

    public UserDto getUserByLogin(String login);

    public UserDto getUserByEmail(String email);


}

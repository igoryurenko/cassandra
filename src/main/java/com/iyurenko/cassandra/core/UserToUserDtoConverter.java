package com.iyurenko.cassandra.core;

import com.iyurenko.cassandra.dao.domain.User;
import com.iyurenko.cassandra.web.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * Created by iyurenko on 14.12.16.
 */
@Component
public class UserToUserDtoConverter{

    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setEmail(user.getEmail());
        userDto.setUserId(user.getUserId());
        userDto.setAge(user.getAge());
        userDto.setHeight(user.getHeight());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setWeight(user.getWeight());

        return userDto;

    }

    public void convertFromDto(UserDto userDto, User user) {
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setUserId(userDto.getUserId());
        user.setAge(userDto.getAge());
        user.setHeight(userDto.getHeight());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setWeight(userDto.getWeight());

        user.setPass(userDto.getPass());

    }

}

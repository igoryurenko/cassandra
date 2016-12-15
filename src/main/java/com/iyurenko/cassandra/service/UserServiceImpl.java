package com.iyurenko.cassandra.service;

import com.datastax.driver.core.utils.UUIDs;
import com.datastax.driver.mapping.Mapper;
import com.iyurenko.cassandra.core.UserToUserDtoConverter;
import com.iyurenko.cassandra.dao.repository.user.UserByEmailRepository;
import com.iyurenko.cassandra.dao.repository.user.UserByLoginRepository;
import com.iyurenko.cassandra.dao.domain.UserByEmail;
import com.iyurenko.cassandra.dao.domain.UserByLogin;
import com.iyurenko.cassandra.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by iyurenko on 02.12.16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserByLoginRepository userByLoginRepository;

    @Autowired
    private UserByEmailRepository userByEmailRepository;

    @Autowired
    private UserToUserDtoConverter userToUserDtoConverter;


    @Override
    public void insertUser(UserDto userDto) {
        userDto.setUserId(UUIDs.random());

        UserByLogin userByLogin = new UserByLogin();
        UserByEmail userByEmail = new UserByEmail();

        userToUserDtoConverter.convertFromDto(userDto, userByLogin);
        userToUserDtoConverter.convertFromDto(userDto, userByEmail);

        userByLoginRepository.insertUserIfExists(userByLogin);
        userByEmailRepository.insertUserIfExists(userByEmail);
    }

    @Override
    public void updateUser(UserDto userDto) {
        Mapper.Option option = Mapper.Option.timestamp(UUIDs.timeBased().timestamp());

        UserByLogin userByLogin = new UserByLogin();
        UserByEmail userByEmail = new UserByEmail();

        userToUserDtoConverter.convertFromDto(userDto, userByLogin);
        userToUserDtoConverter.convertFromDto(userDto, userByEmail);

        userByLoginRepository.save(userByLogin, option);
        userByEmailRepository.save(userByEmail, option);
    }

    @Override
    public UserDto getUserByLogin(String login) {
        return userToUserDtoConverter.convertToDto(userByLoginRepository.get(login));
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return userToUserDtoConverter.convertToDto(userByEmailRepository.get(email));
    }


}

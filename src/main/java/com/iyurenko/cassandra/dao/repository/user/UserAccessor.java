package com.iyurenko.cassandra.dao.repository.user;

import com.datastax.driver.core.ResultSet;

import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
public interface UserAccessor {

    ResultSet insertUser(String email, String login, UUID userId,
                         String pass, String name,String surname, int weight,
                         int height, int age);

}

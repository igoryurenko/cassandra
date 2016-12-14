package com.iyurenko.cassandra.dao.repository.user;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;

import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
@Accessor
public interface UserByLoginAccessor extends UserAccessor {

    @Query(
            "INSERT INTO users_by_login (email, login, user_id, pass, name, surname, weight, height, age) " +
                    "VALUES (:email, :login, :userId, :pass, :name, :surname, :weight, :height, :age)" +
                    " IF NOT EXISTS"
    )
    ResultSet insertUser(@Param("email") String email, @Param("login") String login, @Param("userId") UUID userId,
                         @Param("pass") String pass, @Param("name") String name, @Param("surname") String surname, @Param("weight") int weight,
                         @Param("height") int height, @Param("age") int age);

}

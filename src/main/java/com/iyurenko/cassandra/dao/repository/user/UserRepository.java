package com.iyurenko.cassandra.dao.repository.user;

import com.iyurenko.cassandra.dao.repository.CassandraRepository;
import com.iyurenko.cassandra.dao.domain.User;

/**
 * Created by iyurenko on 14.12.16.
 */
public abstract class UserRepository<T extends User, A extends UserAccessor> extends CassandraRepository<T, A> {

    public void insertUserIfExists(T user) {
        accessor.insertUser(user.getEmail(), user.getLogin(), user.getUserId(),
                user.getPass(), user.getName(), user.getSurname(),
                user.getWeight(), user.getHeight(), user.getAge());

    };

}

package com.iyurenko.cassandra.dao.repository.user;

import com.datastax.driver.core.ResultSet;
import com.iyurenko.cassandra.dao.repository.CassandraRepository;
import com.iyurenko.cassandra.dao.domain.User;

import javax.annotation.PostConstruct;

/**
 * Created by iyurenko on 14.12.16.
 */
public abstract class UserRepository<T extends User, A extends UserAccessor> extends CassandraRepository<T> {

    protected A userAccessor;

    @PostConstruct
    private void init() {
        userAccessor = mappingManager.createAccessor(getAccessorClazz());
    }

    public void insertUserIfExists(T user) {
        userAccessor.insertUser(user.getEmail(), user.getLogin(), user.getUserId(),
                user.getPass(), user.getName(), user.getSurname(),
                user.getWeight(), user.getHeight(), user.getAge());

    };

    public abstract Class<A> getAccessorClazz();

}

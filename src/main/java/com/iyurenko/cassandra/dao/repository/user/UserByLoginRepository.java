package com.iyurenko.cassandra.dao.repository.user;

import com.iyurenko.cassandra.dao.domain.UserByLogin;
import org.springframework.stereotype.Repository;

/**
 * Created by iyurenko on 02.12.16.
 */
@Repository
public class UserByLoginRepository extends UserRepository<UserByLogin, UserByLoginAccessor> {

    @Override
    protected Class<UserByLogin> getClazz() {
        return UserByLogin.class;
    }

    @Override
    public Class<UserByLoginAccessor> getAccessorClazz() {
        return UserByLoginAccessor.class;
    }
}

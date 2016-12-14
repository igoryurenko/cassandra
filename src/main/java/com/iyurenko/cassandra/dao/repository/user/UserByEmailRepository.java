package com.iyurenko.cassandra.dao.repository.user;

import com.iyurenko.cassandra.dao.domain.UserByEmail;
import org.springframework.stereotype.Repository;

/**
 * Created by iyurenko on 02.12.16.
 */
@Repository
public class UserByEmailRepository extends UserRepository<UserByEmail, UserByEmailAccessor> {

    @Override
    protected Class<UserByEmail> getClazz() {
        return UserByEmail.class;
    }

    @Override
    public Class getAccessorClazz() {
        return UserByEmailAccessor.class;
    }
}

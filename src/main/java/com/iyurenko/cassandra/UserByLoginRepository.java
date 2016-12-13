package com.iyurenko.cassandra;

import org.springframework.stereotype.Repository;

/**
 * Created by iyurenko on 02.12.16.
 */
@Repository
public class UserByLoginRepository extends CassandraRepository<UserByLogin> {

    @Override
    protected Class<UserByLogin> getClazz() {
        return UserByLogin.class;
    }

}

package com.iyurenko.cassandra;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by iyurenko on 02.12.16.
 */
@Repository
public class UserByEmailRepository extends CassandraRepository<UserByEmail> {

    @Override
    protected Class<UserByEmail> getClazz() {
        return UserByEmail.class;
    }

}

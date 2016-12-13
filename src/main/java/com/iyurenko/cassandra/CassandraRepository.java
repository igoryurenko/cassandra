package com.iyurenko.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by iyurenko on 08.12.16.
 */
public abstract class CassandraRepository<T> {

    @Autowired
    private Session session;

    @Autowired
    private MappingManager mappingManager;

    protected Mapper<T> mapper;

    @PostConstruct
    private void init() {
        mapper = mappingManager.mapper(getClazz());
    }

    protected Session getSession() {
        return session;
    }

    protected void save(T object) {
        mapper.save(object);
    }

    protected T get(Object... primaryKey) {
        return mapper.get(primaryKey);
    }

    protected void delete(Object... primaryKey) {
        mapper.delete(primaryKey);
    }

    protected void delete(T entity) {
        mapper.delete(entity);
    }

    protected abstract Class<T> getClazz();


}

package com.iyurenko.cassandra.dao.repository;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by iyurenko on 08.12.16.
 */
public abstract class CassandraRepository<T, A> {

    @Autowired
    protected Session session;

    @Autowired
    protected MappingManager mappingManager;

    protected Mapper<T> mapper;

    protected A accessor;

    @PostConstruct
    private void init() {
        mapper = mappingManager.mapper(getClazz());
        accessor = mappingManager.createAccessor(getAccessorClazz());
    }

    protected abstract Class<A> getAccessorClazz();

    protected abstract Class<T> getClazz();

    public void save(T object, Mapper.Option... options) {
        mapper.save(object, options);
    }

    public T get(Object... primaryKey) {
        return mapper.get(primaryKey);
    }

    public void delete(Object... primaryKey) {
        mapper.delete(primaryKey);
    }

    public void delete(T entity) {
        mapper.delete(entity);
    }

}

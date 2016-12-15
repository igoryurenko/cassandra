package com.iyurenko.cassandra.dao.repository.metric;

import com.iyurenko.cassandra.dao.domain.CommonMetric;
import com.iyurenko.cassandra.dao.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
@Repository
public class CommonMetricRepository extends CassandraRepository<CommonMetric, CommonMetricAccessor> {

    @Override
    protected Class getAccessorClazz() {
        return CommonMetricAccessor.class;
    }

    @Override
    protected Class<CommonMetric> getClazz() {
        return CommonMetric.class;
    }


    public List<CommonMetric> getMetricsByDate(UUID userId, Date date) {
        return accessor.getAllFromDate(userId, date).all();
    }

}

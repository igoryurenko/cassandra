package com.iyurenko.cassandra.dao.repository.metric;

import com.iyurenko.cassandra.dao.domain.CommonMetric;
import com.iyurenko.cassandra.dao.domain.HealthRateMetric;
import com.iyurenko.cassandra.dao.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
@Repository
public class HealthRateMetricRepository extends CassandraRepository<HealthRateMetric, HealthRateMetricAccessor> {

    @Override
    protected Class getAccessorClazz() {
        return HealthRateMetricAccessor.class;
    }

    @Override
    protected Class<HealthRateMetric> getClazz() {
        return HealthRateMetric.class;
    }

    public List<HealthRateMetric> getMetricsFromDate(UUID userId, String date) {
        return accessor.getAllFromDate(userId, date).all();
    }
}

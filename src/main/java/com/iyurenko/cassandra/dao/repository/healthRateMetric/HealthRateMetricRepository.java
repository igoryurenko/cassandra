package com.iyurenko.cassandra.dao.repository.healthRateMetric;

import com.iyurenko.cassandra.dao.domain.HealthRateMetric;
import com.iyurenko.cassandra.dao.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by iyurenko on 14.12.16.
 */
@Repository
public class HealthRateMetricRepository extends CassandraRepository<HealthRateMetric> {

    @Override
    protected Class<HealthRateMetric> getClazz() {
        return HealthRateMetric.class;
    }
}

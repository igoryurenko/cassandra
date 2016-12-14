package com.iyurenko.cassandra.dao.repository.commonMetric;

import com.iyurenko.cassandra.dao.domain.CommonMetric;
import com.iyurenko.cassandra.dao.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by iyurenko on 14.12.16.
 */
@Repository
public class CommonMetricRepository extends CassandraRepository<CommonMetric> {

    @Override
    protected Class<CommonMetric> getClazz() {
        return CommonMetric.class;
    }
}

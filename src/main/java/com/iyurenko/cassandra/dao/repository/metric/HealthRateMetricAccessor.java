package com.iyurenko.cassandra.dao.repository.metric;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import com.iyurenko.cassandra.dao.domain.CommonMetric;
import com.iyurenko.cassandra.dao.domain.HealthRateMetric;

import java.util.Date;
import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
@Accessor
public interface HealthRateMetricAccessor {

    @Query("SELECT * FROM heart_rate_metrics where user_id = :userId and date >= :date")
    Result<HealthRateMetric> getAllFromDate(@Param("userId") UUID userId, @Param("date") String date);

}

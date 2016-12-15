package com.iyurenko.cassandra.dao.repository.metric;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import com.iyurenko.cassandra.dao.domain.CommonMetric;

import java.util.Date;
import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
@Accessor
public interface CommonMetricAccessor {

    @Query("SELECT * FROM common_metrics where user_id = :userId and date >= :date")
    Result<CommonMetric> getAllFromDate(@Param("userId") UUID userId, @Param("date") Date date);

}

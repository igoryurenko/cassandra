package com.iyurenko.cassandra.service;

import com.iyurenko.cassandra.dao.domain.HealthRateMetric;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
public interface HealthRateMetricService {

    List<HealthRateMetric> getMetricsByUserFromDate(UUID userId, String date);

    void save(HealthRateMetric healthRateMetric);

}

package com.iyurenko.cassandra.service;

import com.iyurenko.cassandra.dao.domain.HealthRateMetric;
import com.iyurenko.cassandra.dao.repository.metric.HealthRateMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
@Service
public class HealthRateMetricServiceImpl implements HealthRateMetricService {

    @Autowired
    private HealthRateMetricRepository healthRateMetricRepository;

    @Override
    public List<HealthRateMetric> getMetricsByUserFromDate(UUID userId, String date) {
        return healthRateMetricRepository.getMetricsFromDate(userId, date);
    }

    @Override
    public void save(HealthRateMetric healthRateMetric) {
        healthRateMetricRepository.save(healthRateMetric);
    }
}

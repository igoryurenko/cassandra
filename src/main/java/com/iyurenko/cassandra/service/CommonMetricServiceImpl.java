package com.iyurenko.cassandra.service;

import com.iyurenko.cassandra.dao.domain.CommonMetric;
import com.iyurenko.cassandra.dao.repository.metric.CommonMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
@Service
public class CommonMetricServiceImpl implements CommonMetricService {

    @Autowired
    private CommonMetricRepository commonMetricRepository;

    @Override
    public List<CommonMetric> getMetricsByUserFromDate(UUID userId, Date date) {
        return commonMetricRepository.getMetricsByDate(userId, date);
    }

    @Override
    public void save(CommonMetric commonMetric) {
        commonMetricRepository.save(commonMetric);
    }
}

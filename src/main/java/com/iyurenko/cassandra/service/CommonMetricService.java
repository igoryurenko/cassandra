package com.iyurenko.cassandra.service;

import com.iyurenko.cassandra.dao.domain.CommonMetric;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
public interface CommonMetricService {

    List<CommonMetric> getMetricsByUserFromDate(UUID userId, Date date);

    void save(CommonMetric commonMetric);

}

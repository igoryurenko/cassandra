package com.iyurenko.cassandra.service;

import com.iyurenko.cassandra.dao.domain.CommonMetric;
import com.iyurenko.cassandra.dao.domain.HealthRateMetric;
import com.iyurenko.cassandra.dao.domain.UserByLogin;
import com.iyurenko.cassandra.dao.repository.metric.CommonMetricRepository;
import com.iyurenko.cassandra.dao.repository.metric.HealthRateMetricRepository;
import com.iyurenko.cassandra.dao.repository.user.UserByLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by iyurenko on 15.12.16.
 */
@Service
public class WeightServiceImpl implements WeightService {

    @Autowired
    private UserByLoginRepository userRepository;

    @Autowired
    private HealthRateMetricRepository healthRateMetricRepository;

    @Autowired
    private CommonMetricRepository commonMetricRepository;


    @Override
    public double calculateCalories(String login, int desiredWeight) {

        UserByLogin userByLogin = userRepository.get(login);

        int weight = userByLogin.getWeight();
        LocalDate localDate = LocalDate.now().plusMonths(-10);
        UUID userId = userByLogin.getUserId();

        List<HealthRateMetric> healthRateMetrics = healthRateMetricRepository.getMetricsFromDate(userId, localDate.toString());
        List<CommonMetric> commonMetrics = commonMetricRepository.getMetricsByDate(userId, java.sql.Date.valueOf(localDate));

        //average heart rates for the last month
        double averageHeartRate = healthRateMetrics.stream().mapToInt(metric -> metric.getHeartRate()).average().getAsDouble();

        //average activity hours for the last month (by day)
        double averageActivityHours = commonMetrics.stream().collect(
                Collectors.groupingBy(CommonMetric::getDateWithoutTime, Collectors.summingInt(CommonMetric::getPhysicalActivityHours))
        ).values().stream().collect(Collectors.averagingInt(Integer::intValue));

        //average calories for the last month (by day)
        double averageCalories = commonMetrics.stream().collect(
                Collectors.groupingBy(CommonMetric::getDateWithoutTime, Collectors.summingInt(CommonMetric::getFoodCalories))
        ).values().stream().collect(Collectors.averagingInt(Integer::intValue));

        double dailyCalories = 0.014 * weight * 24 * (0.12 * (averageHeartRate- 7));

        double basalMetabolismValue = 66 + (13.7 * weight) + (5 * userByLogin.getHeight()) - (6.8 * userByLogin.getAge());

        double normalDailyCalories = basalMetabolismValue * (averageActivityHours/30 + 1.2);

        double result =  averageCalories - dailyCalories + normalDailyCalories;

        if (desiredWeight > weight) {
            result +=  result * 0.2;
        } else {
            result -=  result * 0.2;
        }

        return result;
    }
}

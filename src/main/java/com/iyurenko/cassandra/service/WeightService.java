package com.iyurenko.cassandra.service;

import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
public interface WeightService {

    double calculateCalories(String login, int desiredWeight);

}

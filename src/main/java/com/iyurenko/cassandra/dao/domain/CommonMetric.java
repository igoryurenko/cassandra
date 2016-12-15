package com.iyurenko.cassandra.dao.domain;

import com.datastax.driver.mapping.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
@Table(keyspace = "healthapp", name = "common_metrics", readConsistency = "LOCAL_QUORUM", writeConsistency = "LOCAL_QUORUM")
public class CommonMetric {

    @PartitionKey
    @Column(name = "user_id")
    private UUID userId;

    @ClusteringColumn
    @Column(name = "date")
    private Date date;

    @Column(name = "physical_activity_hours")
    private int physicalActivityHours;

    @Column(name = "food_calories")
    private int foodCalories;

    /* ----------- getters and setters -------- */

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    @Transient
    public LocalDate getDateWithoutTime() {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPhysicalActivityHours() {
        return physicalActivityHours;
    }

    public void setPhysicalActivityHours(int physicalActivityHours) {
        this.physicalActivityHours = physicalActivityHours;
    }

    public int getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(int foodCalories) {
        this.foodCalories = foodCalories;
    }
}

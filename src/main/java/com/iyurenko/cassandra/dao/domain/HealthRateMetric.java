package com.iyurenko.cassandra.dao.domain;

import com.datastax.driver.core.TimestampGenerator;
import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
@Table(keyspace = "healthapp", name = "heart_rate_metrics", readConsistency = "LOCAL_QUORUM", writeConsistency = "LOCAL_QUORUM")
public class HealthRateMetric {

    @PartitionKey
    @Column(name = "user_id")
    private UUID userId;

    @ClusteringColumn(0)
    @Column(name = "date")
    private String date;

    @ClusteringColumn(1)
    @Column(name = "time")
    private Date time;

    @Column(name = "heart_rate")
    private int heartRate;

    /* ---------- getters and setters ---------- */

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }
}

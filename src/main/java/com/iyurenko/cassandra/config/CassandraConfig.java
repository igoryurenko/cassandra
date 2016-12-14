package com.iyurenko.cassandra.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.TokenAwarePolicy;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iyurenko on 02.12.16.
 */
@Configuration
public class CassandraConfig{


    @Bean
    public Cluster cassandraCluster() {
        return Cluster
                .builder()
                .addContactPoint("localhost")
                .withRetryPolicy(DefaultRetryPolicy.INSTANCE)
                .withLoadBalancingPolicy(
                        new TokenAwarePolicy(DCAwareRoundRobinPolicy.builder().build()))
                .build();
    }

    @Bean
    public Session cassandraSession() {
        return cassandraCluster().connect("healthapp");
    }

    @Bean
    public MappingManager cassandraMappingManager() {
        return new MappingManager(cassandraSession());
    }


}

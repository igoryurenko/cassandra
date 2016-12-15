package com.iyurenko.cassandra.web;

import com.iyurenko.cassandra.dao.domain.HealthRateMetric;
import com.iyurenko.cassandra.service.HealthRateMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
@Controller
@RequestMapping("/heart/rate")
public class HealthRateMetricController {

    @Autowired
    private HealthRateMetricService healthRateMetricService;

    @RequestMapping(value = "/{userId}/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<HealthRateMetric> getMetricsByUserFromDate(@PathVariable UUID userId, @PathVariable String date) {
        return healthRateMetricService.getMetricsByUserFromDate(userId, date);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HealthRateMetric save(@RequestBody HealthRateMetric metric) {
        healthRateMetricService.save(metric);
        return metric;
    }

}

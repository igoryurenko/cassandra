package com.iyurenko.cassandra.web;

import com.iyurenko.cassandra.dao.domain.CommonMetric;
import com.iyurenko.cassandra.service.CommonMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/common/metric")
public class CommonMetricController {

    @Autowired
    private CommonMetricService commonMetricService;

    @RequestMapping(value = "/{userId}/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CommonMetric> getMetricsByUserFromDate(@PathVariable UUID userId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return commonMetricService.getMetricsByUserFromDate(userId, date);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CommonMetric save(@RequestBody CommonMetric metric) {
        commonMetricService.save(metric);
        return metric;
    }

}

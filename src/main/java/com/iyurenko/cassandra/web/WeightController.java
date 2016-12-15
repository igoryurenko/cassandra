package com.iyurenko.cassandra.web;

import com.iyurenko.cassandra.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by iyurenko on 15.12.16.
 */
@Controller
@RequestMapping("/weight")
public class WeightController {

    @Autowired
    private WeightService weightService;

    @RequestMapping(value = "/{login}/{desiredWeight}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Double calculateCaloriesForEveryDayUsage(@PathVariable String login, @PathVariable int desiredWeight) {
        return weightService.calculateCalories(login, desiredWeight);
    }

}

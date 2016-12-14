package com.iyurenko.cassandra.web;

import com.iyurenko.cassandra.dao.domain.UserByEmail;
import com.iyurenko.cassandra.dao.domain.UserByLogin;
import com.iyurenko.cassandra.service.UserService;
import com.iyurenko.cassandra.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return userDto;
    }

    @RequestMapping(value = "/byLogin/{login}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @RequestMapping(value = "/byEmail/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

}

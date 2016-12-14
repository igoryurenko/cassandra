package com.iyurenko.cassandra.web.dto;

import com.datastax.driver.mapping.annotations.Column;
import com.iyurenko.cassandra.dao.domain.User;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
public class UserDto implements Serializable {

    private String email;

    private String login;

    private UUID userId;

    private String name;

    private String surname;

    private int weight;

    private int height;

    private int age;

    private String pass;

    /* ---------- getters and setters ---------- */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

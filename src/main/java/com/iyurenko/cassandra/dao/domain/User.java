package com.iyurenko.cassandra.dao.domain;

import java.util.UUID;

/**
 * Created by iyurenko on 14.12.16.
 */
public interface User {

    public String getEmail();

    public void setEmail(String email);

    public String getLogin();

    public void setLogin(String login);

    public UUID getUserId();

    public void setUserId(UUID userId);

    public String getPass();

    public void setPass(String pass);

    public String getName();

    public void setName(String name);

    public String getSurname();

    public void setSurname(String surname);

    public int getWeight();

    public void setWeight(int weight);

    public int getHeight();

    public void setHeight(int height);

    public int getAge();

    public void setAge(int age);
}

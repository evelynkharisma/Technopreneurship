package com.techno.technopreneurship.Object;

import java.util.Date;

/**
 * Created by User on 4/1/2016.
 */
public class HealthDetails {
    private String username;
    private String name;
    private Date birthday;
    private double weight;
    private double height;

    public HealthDetails() {}

    public HealthDetails(String username, String name, Date birthday, double weight, double height) {
        this.username = username;
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

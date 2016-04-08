package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/8/2016.
 */
public class HeartRate {
    private String user;
    private String name;
    private String date;
    private double heartRate;

    public  HeartRate(){}

    public HeartRate(String user, String name, String date, double heartRate) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.heartRate = heartRate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }
}

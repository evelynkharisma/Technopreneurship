package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/8/2016.
 */
public class Diabetes {
    private String user;
    private String name;
    private String date;
    private double diabetes;

    public  Diabetes(){}

    public Diabetes(String user, String name, String date, double diabetes) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.diabetes = diabetes;
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

    public double getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(double diabetes) {
        this.diabetes = diabetes;
    }
}

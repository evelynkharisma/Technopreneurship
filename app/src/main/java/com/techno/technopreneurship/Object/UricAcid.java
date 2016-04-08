package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/8/2016.
 */
public class UricAcid {
    private String user;
    private String name;
    private String date;
    private double uricAcid;

    public UricAcid(){}

    public UricAcid(String user, String name, String date, double uricAcid) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.uricAcid = uricAcid;
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

    public double getUricAcid() {
        return uricAcid;
    }

    public void setUricAcid(double uricAcid) {
        this.uricAcid = uricAcid;
    }
}

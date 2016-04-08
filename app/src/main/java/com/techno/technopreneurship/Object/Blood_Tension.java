package com.techno.technopreneurship.Object;

import com.techno.technopreneurship.BloodTensionFragment;

/**
 * Created by User on 4/8/2016.
 */
public class Blood_Tension {
    private String user;
    private String name;
    private String date;
    private double systol;
    private double diastol;

    public Blood_Tension(){}

    public Blood_Tension(String user, String name, String date, double systol, double diastol) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.systol = systol;
        this.diastol = diastol;
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

    public double getSystol() {
        return systol;
    }

    public void setSystol(double systol) {
        this.systol = systol;
    }

    public double getDiastol() {
        return diastol;
    }

    public void setDiastol(double diastol) {
        this.diastol = diastol;
    }
}

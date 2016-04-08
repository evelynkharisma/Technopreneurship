package com.techno.technopreneurship.Object;

import java.util.Date;

/**
 * Created by User on 4/8/2016.
 */
public class Blood_Count {
    private String user;
    private String name;
    private String date;
    private double redBC;
    private double whiteBC;
    private double thrombocyte;

    public Blood_Count(){}

    public Blood_Count(String user, String name, String date, double redBC, double whiteBC, double thrombocyte)
    {
        this.user = user;
        this.name = name;
        this.date = date;
        this.redBC = redBC;
        this.whiteBC = whiteBC;
        this.thrombocyte = thrombocyte;
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

    public double getRedBC() {
        return redBC;
    }

    public void setRedBC(double redBC) {
        this.redBC = redBC;
    }

    public double getWhiteBC() {
        return whiteBC;
    }

    public void setWhiteBC(double whiteBC) {
        this.whiteBC = whiteBC;
    }

    public double getThrombocyte() {
        return thrombocyte;
    }

    public void setThrombocyte(double thrombocyte) {
        this.thrombocyte = thrombocyte;
    }
}

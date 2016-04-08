package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/8/2016.
 */
public class Cholesterol {
    private String user;
    private String name;
    private String date;
    private double hdl;
    private double ldl;
    private double total;

    public Cholesterol(String user, String name, String date, double hdl, double ldl, double total) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.hdl = hdl;
        this.ldl = ldl;
        this.total = total;
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

    public double getHdl() {
        return hdl;
    }

    public void setHdl(double hdl) {
        this.hdl = hdl;
    }

    public double getLdl() {
        return ldl;
    }

    public void setLdl(double ldl) {
        this.ldl = ldl;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

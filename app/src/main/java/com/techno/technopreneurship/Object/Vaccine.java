package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/8/2016.
 */
public class Vaccine {
    private String user;
    private String name;
    private String date;
    private String vaccine;
    private String stage;

    public Vaccine(){}

    public Vaccine(String user, String name, String date, String vaccine, String stage) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.vaccine = vaccine;
        this.stage = stage;
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

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}

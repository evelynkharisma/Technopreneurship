package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/8/2016.
 */
public class UrineTest {
    private String user;
    private String name;
    private String date;
    private boolean protein;
    private boolean glucose;
    private boolean blood;

    public UrineTest(){}

    public UrineTest(String user, String name, String date, boolean protein, boolean glucose, boolean blood) {
        this.user = user;
        this.name = name;
        this.date = date;
        this.protein = protein;
        this.glucose = glucose;
        this.blood = blood;
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

    public boolean isProtein() {
        return protein;
    }

    public void setProtein(boolean protein) {
        this.protein = protein;
    }

    public boolean isGlucose() {
        return glucose;
    }

    public void setGlucose(boolean glucose) {
        this.glucose = glucose;
    }

    public boolean isBlood() {
        return blood;
    }

    public void setBlood(boolean blood) {
        this.blood = blood;
    }
}

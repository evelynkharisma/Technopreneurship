package com.techno.technopreneurship.Object;

/**
 * Created by janistan on 4/14/2016.
 */
public class Doctor {
    private Integer id;
    private String name;

    public Doctor() {
    }

    public Doctor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

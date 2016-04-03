package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/3/2016.
 */
public class Allergy {
    private String user;
    private String name;
    private String allergy;

    public Allergy(){}

    public Allergy(String user, String name, String allergy){
        this.user = user;
        this.name = name;
        this.allergy = allergy;
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

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}

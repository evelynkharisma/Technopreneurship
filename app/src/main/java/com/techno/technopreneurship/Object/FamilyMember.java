package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/1/2016.
 */
public class FamilyMember {
    public FamilyMember(){}

    public FamilyMember(String user, String name, String status){
        this.user = user;
        this.name = name;
        this.status = status;
    }

    private String user;
    private String name;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

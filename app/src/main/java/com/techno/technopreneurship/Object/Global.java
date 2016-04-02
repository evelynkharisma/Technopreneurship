package com.techno.technopreneurship.Object;

import java.util.ArrayList;

/**
 * Created by User on 4/1/2016.
 */
public class Global {
    public Global(){}

    private String currentUser = "user";
    private String addFamName;
    private String addFamStatus;

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getAddFamName() {
        return addFamName;
    }

    public void setAddFamName(String addFamName) {
        this.addFamName = addFamName;
    }

    public String getAddFamStatus() {
        return addFamStatus;
    }

    public void setAddFamStatus(String addFamStatus) {
        this.addFamStatus = addFamStatus;
    }
}

package com.techno.technopreneurship.Object;

import java.util.ArrayList;

/**
 * Created by janistan on 4/9/2016.
 */
public class User {
    private String username;
    private String password;
    private Boolean firstThreeReward = true;
    private Boolean firstDataAllergy = true;
    private Boolean firstDataBloodCount = true;
    private Boolean firstDataBloodTension = true;
    private Boolean firstDataCholesterol = true;
    private Boolean firstDataDiabetes = true;
    private Boolean firstDataHealthRate = true;
    private Boolean firstDataUricAcid = true;
    private Boolean firstDataUrineTest = true;
    private Boolean firstDataVaccine = true;
    private ArrayList<Doctor> favorite = new ArrayList<>();

    public User() {}

    public User(String user,String pass) {
        setUsername(user);
        setPassword(pass);
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public Boolean getFirstDataVaccine() {
        return firstDataVaccine;
    }

    public void setFirstDataVaccine(Boolean firstDataVaccine) {
        this.firstDataVaccine = firstDataVaccine;
    }

    public Boolean getFirstThreeReward() {
        return firstThreeReward;
    }

    public void setFirstThreeReward(Boolean firstThreeReward) {
        this.firstThreeReward = firstThreeReward;
    }

    public Boolean getFirstDataAllergy() {
        return firstDataAllergy;
    }

    public void setFirstDataAllergy(Boolean firstDataAllergy) {
        this.firstDataAllergy = firstDataAllergy;
    }

    public Boolean getFirstDataBloodCount() {
        return firstDataBloodCount;
    }

    public void setFirstDataBloodCount(Boolean firstDataBloodCount) {
        this.firstDataBloodCount = firstDataBloodCount;
    }

    public Boolean getFirstDataBloodTension() {
        return firstDataBloodTension;
    }

    public void setFirstDataBloodTension(Boolean firstDataBloodTension) {
        this.firstDataBloodTension = firstDataBloodTension;
    }

    public Boolean getFirstDataCholesterol() {
        return firstDataCholesterol;
    }

    public void setFirstDataCholesterol(Boolean firstDataCholesterol) {
        this.firstDataCholesterol = firstDataCholesterol;
    }

    public Boolean getFirstDataDiabetes() {
        return firstDataDiabetes;
    }

    public void setFirstDataDiabetes(Boolean firstDataDiabetes) {
        this.firstDataDiabetes = firstDataDiabetes;
    }

    public Boolean getFirstDataHealthRate() {
        return firstDataHealthRate;
    }

    public void setFirstDataHealthRate(Boolean firstDataHealthRate) {
        this.firstDataHealthRate = firstDataHealthRate;
    }

    public Boolean getFirstDataUricAcid() {
        return firstDataUricAcid;
    }

    public void setFirstDataUricAcid(Boolean firstDataUricAcid) {
        this.firstDataUricAcid = firstDataUricAcid;
    }

    public Boolean getFirstDataUrineTest() {
        return firstDataUrineTest;
    }

    public void setFirstDataUrineTest(Boolean firstDataUrineTest) {
        this.firstDataUrineTest = firstDataUrineTest;
    }

    public ArrayList<Doctor> getFavorite() {
        return favorite;
    }

    public void setFavorite(ArrayList<Doctor> favorite) {
        this.favorite = favorite;
    }
}

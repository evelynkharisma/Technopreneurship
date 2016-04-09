package com.techno.technopreneurship.Object;

/**
 * Created by User on 4/1/2016.
 */
public class FamilyMember {
    private String username;
    private String name;
    private String status;
    private String address;
    private String email;
    private String gender;
    private Long phone;
    private Integer ktp;
    private String emergencyName;
    private Long emergencyPhone;

    public FamilyMember() {}

    public FamilyMember(String username, String name, String gender, String status, String address, String email, Long phone, Integer ktp, String emergencyName, Long emergencyPhone) {
        this.username = username;
        this.name = name;
        this.status = status;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.ktp = ktp;
        this.emergencyName = emergencyName;
        this.emergencyPhone = emergencyPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getKtp() {
        return ktp;
    }

    public void setKtp(Integer ktp) {
        this.ktp = ktp;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public Long getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(Long emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }
}

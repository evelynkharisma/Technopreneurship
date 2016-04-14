package com.techno.technopreneurship.Object;

/**
 * Created by janistan on 4/14/2016.
 */
public class Hospital {
    private Integer id;
    private String name;
    private Integer doctorId;
    private String day;
    private String startTime;
    private String endTime;

    public Hospital() {
    }

    public Hospital(Integer id, String name, Integer doctorId, String day, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.doctorId = doctorId;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

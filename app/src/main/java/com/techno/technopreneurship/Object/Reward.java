package com.techno.technopreneurship.Object;

/**
 * Created by janistan on 4/12/2016.
 */
public class Reward {

    private String username;
    private String date;
    private String detail;
    private String type;
    private Integer voucher;
    private Boolean available;
    private Boolean used = false;

    public Reward() { }

    public Reward(String username, String date, String detail, String type, Integer voucher, Boolean available) {
        this.username = username;
        this.date = date;
        this.detail = detail;
        this.type = type;
        this.voucher = voucher;
        this.available = available;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVoucher() {
        return voucher;
    }

    public void setVoucher(Integer voucher) {
        this.voucher = voucher;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
}

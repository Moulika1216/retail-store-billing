package com.retailstore.billing.modal;

import java.time.LocalDate;

public class User {

    private Long userId;
    private String username;
    private String mobileNo;
    private String userType;
    private LocalDate createdDt;

    public User(Long userId, String username, String mobileNo, String userType, LocalDate createdDt) {
        this.userId = userId;
        this.username = username;
        this.mobileNo = mobileNo;
        this.userType = userType;
        this.createdDt = createdDt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public LocalDate getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(LocalDate createdDt) {
        this.createdDt = createdDt;
    }
}

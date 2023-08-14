package com.example.backproject.Domain;


import javax.persistence.Entity;


public class AuthenticationBean {
    public String getUsername() {
        return username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public AuthenticationBean(String username,String pwd) {
        this.username = username;
        this.pwd=pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthenticationBean() {
    }

    private String username;
    private String pwd;

}

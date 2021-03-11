package com.example.istudy.models;

import java.io.Serializable;

public class LoginResponse {

    private String token;
    private User user;
    //private String access;


    public LoginResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

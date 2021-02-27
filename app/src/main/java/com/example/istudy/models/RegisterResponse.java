package com.example.istudy.models;

public class RegisterResponse {

    private String response;
    private String email;
    private String username;
    private String full_name;
    private int phone_number;


    public RegisterResponse(String response, String email, String username, String full_name, int phone_number) {
        this.response = response;
        this.email = email;
        this.username = username;
        this.full_name = full_name;
        this.phone_number = phone_number;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}

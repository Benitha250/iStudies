package com.example.istudy.models;

public class RegisterRequest {
    private String full_name;
    private String username;
    private String email;
    private String role;
    private String phone_number;
    private String password;
    private String password2;

    public RegisterRequest(String full_name, String username, String email, String role, String phone_number, String password, String password2) {
        this.full_name = full_name;
        this.username = username;
        this.email = email;
        this.role = role;
        this.phone_number = phone_number;
        this.password = password;
        this.password2 = password2;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}

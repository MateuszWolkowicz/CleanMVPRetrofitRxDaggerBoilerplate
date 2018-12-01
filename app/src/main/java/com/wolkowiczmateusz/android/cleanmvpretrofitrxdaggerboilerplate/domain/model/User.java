package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model;

public class User {

    private String sessionToken;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
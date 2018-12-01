package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api;


public class UserResponse {

    public String username;
    public String objectId;
    public String email;
    public String firstName;
    public String lastName;
    public String sessionToken;

    @Override
    public String toString() {
        return "UserResponse{" +
                "username='" + username + '\'' +
                ", objectid='" + objectId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                '}';
    }
}

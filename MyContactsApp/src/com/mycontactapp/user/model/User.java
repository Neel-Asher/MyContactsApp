package com.mycontactapp.user.model;

import java.util.HashMap;
import java.util.Map;

public abstract class User {

    public enum UserType {
        Free,
        Premium
    }

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private Map<String,String> preferences = new HashMap<>();

    protected User(String email,String password,String firstName,String lastName) {
        this.email=email;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public Map<String,String> getPreferences() { return preferences; }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public void setPreference(String key,String value) {
        preferences.put(key,value);
    }

    public abstract UserType getUserType();
}
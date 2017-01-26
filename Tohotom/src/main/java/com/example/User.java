package com.example;

/**
 * Created by Zoltán on 2017.01.26..
 */
public class User {
    String name = "Unknown";

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

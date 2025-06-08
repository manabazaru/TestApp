package com.example.demo;

public class MyUser {
    private String id;
    private String password;

    public MyUser(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

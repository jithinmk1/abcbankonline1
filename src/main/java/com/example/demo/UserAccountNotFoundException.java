package com.example.demo;

public class UserAccountNotFoundException extends Exception {
    private int user_id;
    public UserAccountNotFoundException(int user_id)
    {
        super(String.format("loan is not found + %s",user_id));
    }
}

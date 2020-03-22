package com.example.demo;

public class AccountNotFoundException extends Exception {
    private int id;
    public AccountNotFoundException(int id)
    {
        super(String.format("Account is not found + %s",id));
    }
}



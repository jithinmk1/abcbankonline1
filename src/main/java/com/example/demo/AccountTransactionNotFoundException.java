package com.example.demo;

public class AccountTransactionNotFoundException extends Exception {

    private int account_Id;
    public AccountTransactionNotFoundException(int account_Id)
    {
        super(String.format("user is not found + %s",account_Id));
    }

}




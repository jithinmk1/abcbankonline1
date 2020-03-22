package com.example.demo;

public class UserNotFoundException extends Exception {

        private int id;
        public UserNotFoundException(int id)
        {
            super(String.format("user is not found + %s",id));
        }

    }




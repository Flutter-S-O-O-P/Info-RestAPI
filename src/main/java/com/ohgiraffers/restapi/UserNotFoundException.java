package com.ohgiraffers.restapi;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String msg){
        super(msg);
    }
}

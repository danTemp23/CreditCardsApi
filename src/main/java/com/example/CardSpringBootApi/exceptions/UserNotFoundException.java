package com.example.CardSpringBootApi.exceptions;

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException() {
        super("User with given OIB cannot be found.");
    }
}
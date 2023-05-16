package com.example.CardSpringBootApi.exceptions;

public class UserAlreadyExistException extends IllegalArgumentException {
    public UserAlreadyExistException() {
        super("User with given OIB already exists.");
    }
}

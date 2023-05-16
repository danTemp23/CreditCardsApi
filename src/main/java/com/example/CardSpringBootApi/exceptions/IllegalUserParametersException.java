package com.example.CardSpringBootApi.exceptions;

public class IllegalUserParametersException extends IllegalArgumentException {
    public IllegalUserParametersException(String message){
        super(message);
    }
}


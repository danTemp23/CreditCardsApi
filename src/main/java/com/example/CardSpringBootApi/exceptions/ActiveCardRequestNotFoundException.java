package com.example.CardSpringBootApi.exceptions;

public class ActiveCardRequestNotFoundException extends IllegalArgumentException {
    public ActiveCardRequestNotFoundException() {
        super("Active card request for user with given OIB cannot be found.");
    }
}

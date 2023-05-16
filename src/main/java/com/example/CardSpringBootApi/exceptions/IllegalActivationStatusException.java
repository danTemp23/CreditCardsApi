package com.example.CardSpringBootApi.exceptions;

import com.example.CardSpringBootApi.model.UserStatus;

public class IllegalActivationStatusException extends IllegalArgumentException {
    public IllegalActivationStatusException() {
        super(("User cannot be registered with %s status, but only with %s status. Request for card creation must be " +
                "sent explicitly after registering user. Only after this active status will be given to user.")
                .formatted(UserStatus.ACTIVE_CARD_REQUEST.name(), UserStatus.INACTIVE_CARD_REQUEST.name()));
    }
}
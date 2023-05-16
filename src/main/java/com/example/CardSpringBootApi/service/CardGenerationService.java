package com.example.CardSpringBootApi.service;

import com.example.CardSpringBootApi.model.User;

public interface CardGenerationService {
    void createNewCardRequest(long oib);
    void cancelCardRequest(long oib);
    void inactivateCardRequestFileIfExistent(User user);
}

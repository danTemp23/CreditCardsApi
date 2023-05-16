package com.example.CardSpringBootApi.service;
import com.example.CardSpringBootApi.exceptions.ActiveCardRequestNotFoundException;
import com.example.CardSpringBootApi.model.User;
import com.example.CardSpringBootApi.model.UserStatus;
import com.example.CardSpringBootApi.service.card_request_writer.CardRequestWriter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CardGenerationServiceImpl implements CardGenerationService {
    private final UserService userService;
    private final CardRequestWriter cardRequestWriter;

    public CardGenerationServiceImpl(UserService userService, CardRequestWriter cardRequestWriter) {
        this.userService = userService;
        this.cardRequestWriter = cardRequestWriter;
    }

    @Override
    public void createNewCardRequest(long oib) {
        User user = userService.getUserByOib(oib);
        inactivateCardRequestFileIfExistent(user);
        String newCardRequestPath = createNewCardRequestName(user);
        cardRequestWriter.updateCardRequestFile(newCardRequestPath, user.getDescriptionElements(Optional.of(UserStatus.ACTIVE_CARD_REQUEST)), true);
        userService.updateUser(oib, UserStatus.ACTIVE_CARD_REQUEST, newCardRequestPath);
    }

    @Override
    public void cancelCardRequest(long oib) {
        User user = userService.getUserByOib(oib);
        if (!user.hasCardRequest()) { throw new ActiveCardRequestNotFoundException(); }
        inactivateCardRequestFileIfExistent(user);
        userService.updateUser(oib, UserStatus.INACTIVE_CARD_REQUEST, null);
    }

    public void inactivateCardRequestFileIfExistent(User user) {
        cardRequestWriter.updateCardRequestFile(user.getLatestCardPath(), user.getDescriptionElements(Optional.of(UserStatus.INACTIVE_CARD_REQUEST)), false);
    }

    public String createNewCardRequestName(User user) {
        long timeInMilliseconds = new Date().getTime();
        return String.format("card-request-%d-%d.txt", user.getOib(), timeInMilliseconds);
    }
}

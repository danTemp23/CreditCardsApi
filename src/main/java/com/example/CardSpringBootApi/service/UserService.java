package com.example.CardSpringBootApi.service;

import com.example.CardSpringBootApi.model.User;
import com.example.CardSpringBootApi.model.UserStatus;

public interface UserService {
    User getUserByOib(long oib);
    User saveUser(User user);
    void deleteUser(long oib);
    void deleteUser(User user);
    void updateUser(long oib, UserStatus newStatus, String newCardRequestPath);

}

package com.example.CardSpringBootApi.controller;

import com.example.CardSpringBootApi.dto.UserDto;
import com.example.CardSpringBootApi.mapper.UserMapper;
import com.example.CardSpringBootApi.model.User;
import com.example.CardSpringBootApi.service.CardGenerationService;
import com.example.CardSpringBootApi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;
    private final CardGenerationService cardGenerationService;

    public UserController(UserMapper userMapper, UserService userService, CardGenerationService cardGenerationService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.cardGenerationService = cardGenerationService;
    }

    @GetMapping("/{oib}")
    public UserDto getUser(@PathVariable long oib) {
        return userMapper.userToUserDto(userService.getUserByOib(oib));
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto user) {
        User userModel = userMapper.userDtoToUser(user);
        return userMapper.userToUserDto(userService.saveUser(userModel));
    }

    @DeleteMapping("/{oib}")
    public void deleteUser(@PathVariable long oib) {
        User user = userService.getUserByOib(oib);
        cardGenerationService.inactivateCardRequestFileIfExistent(user);
        userService.deleteUser(user);
    }
}

package com.example.CardSpringBootApi.exceptions.handler;

import com.example.CardSpringBootApi.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = IllegalUserParametersException.class)
    public ResponseEntity<?> handleUserParametersException(IllegalUserParametersException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = IllegalActivationStatusException.class)
    public ResponseEntity<?> handleActiveStatusOnCreatedUserException(IllegalActivationStatusException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ActiveCardRequestNotFoundException.class)
    public ResponseEntity<?> handleActiveCardRequestNotFoundException(ActiveCardRequestNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = CardRequestFileException.class)
    public ResponseEntity<?> handleCardRequestFileException(CardRequestFileException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

}
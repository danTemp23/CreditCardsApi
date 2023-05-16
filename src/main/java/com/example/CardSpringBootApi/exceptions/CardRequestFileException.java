package com.example.CardSpringBootApi.exceptions;

public class CardRequestFileException extends RuntimeException {
    public CardRequestFileException(){
        super("Internal problem with card requests file system.");
    }
}
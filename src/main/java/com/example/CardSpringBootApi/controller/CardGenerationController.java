package com.example.CardSpringBootApi.controller;

import com.example.CardSpringBootApi.service.CardGenerationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card-request")
public class CardGenerationController {
    private final CardGenerationService cardGenerationService;

    public CardGenerationController(CardGenerationService cardGenerationService) {
        this.cardGenerationService = cardGenerationService;
    }

    @PostMapping("/{oib}")
    public void requestCardGeneration(@PathVariable long oib) {
        cardGenerationService.createNewCardRequest(oib);
    }

    @DeleteMapping("/{oib}")
    public void cancelCardGeneration(@PathVariable long oib) {
        cardGenerationService.cancelCardRequest(oib);
    }


}

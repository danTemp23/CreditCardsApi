package com.example.CardSpringBootApi.service.card_request_writer;

import com.example.CardSpringBootApi.exceptions.CardRequestFileException;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class SimpleCardRequestWriter implements CardRequestWriter {

    @Override
    public void updateCardRequestFile(String cardRequestPath, List<String> userDescriptionElements, Boolean createIfNonExistent) {
        if (cardRequestPath == null ) { return; }
        try {
            if (!createIfNonExistent && !(new File(cardRequestPath)).isFile()) { return; }
            String userDescription = String.join(", ", userDescriptionElements);
            BufferedWriter writer = new BufferedWriter(new FileWriter(cardRequestPath));
            writer.write(userDescription);
            writer.close();
        } catch (IOException ioException) {
            throw new CardRequestFileException();
        }
    }
}

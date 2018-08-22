package com.peer2pay.peer2pay.helperClasses.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peer2pay.peer2pay.helperClasses.objects.Card;

import java.io.IOException;

public class CardParser extends JsonParser {
    private ObjectMapper mapper = new ObjectMapper();

    public Card parseCard(String json){
        try {
            return mapper.readerFor(Card.class).readValue(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Card();
    }
}

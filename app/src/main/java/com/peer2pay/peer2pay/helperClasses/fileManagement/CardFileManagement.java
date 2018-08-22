package com.peer2pay.peer2pay.helperClasses.fileManagement;

import android.content.Context;
import android.content.SharedPreferences;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.peer2pay.peer2pay.helperClasses.card.Card;
import com.peer2pay.peer2pay.helperClasses.parser.CardParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardFileManagement extends FileManagement {
    private CardParser cardParser;

    public CardFileManagement(Context context) {
        super(context);
    }

    public List<String> getAllCards(){
        SharedPreferences preferences = getPreference();
        Map<String, ?> allPreferences = preferences.getAll();
        return allPreferences.keySet().stream()
                .filter(k -> k.matches("card_row_\\d+"))
                .map(this::getSharedPreferenceString)
                .collect(Collectors.toList());
    }

    public void deleteCard(String name){
        removeSharedPreference(name);
        //TODO put check to see if cards deleted
    }

    public JsonNode getCardAsJson(String name){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(getSharedPreferenceString(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NullNode.getInstance();
    }

    public String getCardAsString(String name){
        return getSharedPreferenceString(name);
    }

    public void newCard(String key, String cardNumber, String cardType, String date, String cvc, String postcode, String sortCode, String accountNumber){
        int id = getCountID();
        Card card = new Card();
        card.set(key, cardNumber, cardType, date, cvc, postcode, sortCode, accountNumber, id);

        addSharedPreference("card_row_" + String.valueOf(id) , card.getCardNode());
        setCountID(id + 1);
        //TODO put check to see if cards created
    }
}

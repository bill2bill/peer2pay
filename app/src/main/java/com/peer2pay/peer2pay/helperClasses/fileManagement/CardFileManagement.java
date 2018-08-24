package com.peer2pay.peer2pay.helperClasses.fileManagement;

import android.content.Context;
import android.content.SharedPreferences;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.peer2pay.peer2pay.helperClasses.objects.Card;
import com.peer2pay.peer2pay.helperClasses.parser.CardParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardFileManagement extends FileManagement {
    private final String CARD_NAME = "card_row_";
    private CardParser cardParser;

    public CardFileManagement(Context context) {
        super(context);
    }

    public List<String> getAllCards(){
        SharedPreferences preferences = getPreference();
        Map<String, ?> allPreferences = preferences.getAll();
        return allPreferences.keySet().stream()
                .filter(k -> k.matches(CARD_NAME + "\\d+"))
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

    public void newCard(){
        int id = getCountID();
        String newCardNode = new Card().set(user, token, cardType, date, id).getCardNode();

        addSharedPreference(CARD_NAME + String.valueOf(id) , newCardNode);
        setCountID(id + 1);
        //TODO put check to see if cards created
    }
}

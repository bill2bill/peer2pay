package com.peer2pay.peer2pay.helperClasses.management;

import android.content.Context;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.peer2pay.peer2pay.helperClasses.card.Card;

import java.io.IOException;
import java.util.Map;

public class CardManagement extends FileManagement {
    public CardManagement(Context context) {
        super(context);
    }

    public Map<String, ?> getAllCards(){
        return getPreference().getAll();
    }

    public void deleteCard(String name){
        removeSharedPreference(name);
        //TODO put check to see if cards deleted
    }

    public JsonNode getCardAsJson(String name){
        //TODO make this class abstract
        //TODO this class should only contain information about files
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
        Card card = new Card(key, cardNumber, cardType, date, cvc, postcode, sortCode, accountNumber, id);

        addSharedPreference("card_row" + String.valueOf(id) , card.getCardNode());
        setCountID(id + 1);
        //TODO put check to see if cards created
    }
}

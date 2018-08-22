package com.peer2pay.peer2pay.helperClasses.fileManagement;

import android.content.Context;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;

import java.io.IOException;
import java.util.Map;

public class TransactionFileManagement extends FileManagement {
    public TransactionFileManagement(Context context) {
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

}

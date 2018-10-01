package com.peer2pay.peer2pay.helperClasses.utils.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParser extends Parser {
    private ObjectMapper mapper = new ObjectMapper();

    public JsonNode EMPTY = mapper.createObjectNode();

    public JsonNode stringToJson(String node){
        try {
            return mapper.readTree(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapper.createObjectNode();
    }
}

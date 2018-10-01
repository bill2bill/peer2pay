package com.peer2pay.peer2pay.helperClasses.objects;

import com.peer2pay.peer2pay.helperClasses.utils.Maths;

public class Card {
    private Maths maths = new Maths();
    private final String EMPTY = "";

    private String id = EMPTY;
    private String user = EMPTY;
    private String token = EMPTY;
    private String cardType = EMPTY;
    private String expiration = EMPTY;
    private int countID = 0;

    //Constructor

    public void set(String user, String token, String cardType, String date, int ID) {
        this.user = user;
        this.token = token;
        this.cardType = cardType;
        this.expiration = date;
        this.countID = ID;
    }

    // Methods

    public String getCardNode(){
        return "{" +
                "\"id\":\"" + getCountID() + ", " +
                "\"user\":{\"value\":\"" +user + "\"}" +
                "\"token\":{\"value\":\"" +token + "\"}" +
                "\"expiration\":{\"value\":\"" + expiration + "\"}, " +
                "}";
    }

    //Getters

    public String getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getCardType() {
        return cardType;
    }

    public String getDate() {
        return expiration;
    }

    private int getCountID() {
        return countID;
    }
}

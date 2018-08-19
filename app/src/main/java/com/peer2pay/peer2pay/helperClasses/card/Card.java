package com.peer2pay.peer2pay.helperClasses.card;

import com.peer2pay.peer2pay.helperClasses.Maths;
import com.peer2pay.peer2pay.helperClasses.Security;

public class Card {
    private Maths maths = new Maths();

    public Card(String key, String cardNumber, String cardType, String date, String cvc, String postcode, String sortCode, String accountNumber, int ID) {
        this.key = key;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.date = date;
        this.cvc = cvc;
        this.postcode = postcode;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.countID = ID;
    }

    private String key;
    private String cardNumber;
    private String cardType;
    private String date;
    private String cvc;
    private String postcode;
    private String sortCode;
    private String accountNumber;
    private int countID = 0;

    // Methods

    public String getCardNode(){
        return "{" +
                "\"id\":\"" + getCountID() + ", " +
                "\"cardNumber\":{\"value\":\"" + Security.encrypt(key, cardNumber) + "\", \"isEncrypt\":\"true\"}, " +
                "\"cardNumberLastDigits\":{\"value\":\"" + maths.lastCharacters(4,cardNumber) + "\", \"isEncrypt\":\"false\"}, " +
                "\"expiration\":{\"value\":\"" + date + "\", \"isEncrypt\":\"false\"}, " +
                "\"cvc\":{\"value\":\"" + Security.encrypt(key, String.valueOf(cvc)) + "\", \"isEncrypt\":\"true\"}, " +
                "\"postcode\":{\"value\":\"" + postcode + "\", \"isEncrypt\":\"false\"}, " +
                "\"sortCode\":{\"value\":\"" + Security.encrypt(key, sortCode) + "\", \"isEncrypt\":\"true\"}, " +
                "\"accountNumber\":{\"value\":\"" + Security.encrypt(key, accountNumber) + "\", \"isEncrypt\":\"true\"}}";
    }

    // Setters and Getters

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private int getCountID() {
        return countID;
    }

    public void setCountID(int countID) {
        this.countID = countID;
    }
}

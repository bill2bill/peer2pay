package com.peer2pay.peer2pay.helperClasses.objects;

import com.peer2pay.peer2pay.helperClasses.Maths;
import com.peer2pay.peer2pay.helperClasses.Security;

public class Card {
    private Maths maths = new Maths();
    private final String EMPTY = "";

    private String key = EMPTY;
    private String id = EMPTY;
    private String cardNumber = EMPTY;
    private String cardNumberLastDigits = EMPTY;
    private String cardType = EMPTY;
    private String expiration = EMPTY;
    private String cvc = EMPTY;
    private String postcode = EMPTY;
    private String sortCode = EMPTY;
    private String accountNumber = EMPTY;
    private int countID = 0;

    //Constructor

    public void set(String key, String cardNumber, String cardType, String date, String cvc, String postcode, String sortCode, String accountNumber, int ID) {
        this.key = key;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expiration = date;
        this.cvc = cvc;
        this.postcode = postcode;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.countID = ID;
    }

    // Methods

    public String getCardNode(){
        return "{" +
                "\"id\":\"" + getCountID() + ", " +
                "\"cardNumber\":{\"value\":\"" + Security.encrypt(key, cardNumber) + "\", \"isEncrypt\":\"true\"}, " +
                "\"cardNumberLastDigits\":{\"value\":\"" + maths.lastCharacters(4,cardNumber) + "\", \"isEncrypt\":\"false\"}, " +
                "\"expiration\":{\"value\":\"" + expiration + "\", \"isEncrypt\":\"false\"}, " +
                "\"cvc\":{\"value\":\"" + Security.encrypt(key, String.valueOf(cvc)) + "\", \"isEncrypt\":\"true\"}, " +
                "\"postcode\":{\"value\":\"" + postcode + "\", \"isEncrypt\":\"false\"}, " +
                "\"sortCode\":{\"value\":\"" + Security.encrypt(key, sortCode) + "\", \"isEncrypt\":\"true\"}, " +
                "\"accountNumber\":{\"value\":\"" + Security.encrypt(key, accountNumber) + "\", \"isEncrypt\":\"true\"}}";
    }

    //Getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }


    public String getCardNumberLastDigits() {
        return cardNumberLastDigits;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getDate() {
        return expiration;
    }

    public String getCvc() {
        return cvc;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getSortCode() {
        return sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private int getCountID() {
        return countID;
    }


    //setters

    private void setKey(String key) {
        this.key = key;
    }

    private void setCardNumberLastDigits(String cardNumberLastDigits) {
        this.cardNumberLastDigits = cardNumberLastDigits;
    }

    private void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    private void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private void setCardType(String cardType) {
        this.cardType = cardType;
    }

    private void setDate(String date) {
        this.expiration = date;
    }

    private void setCvc(String cvc) {
        this.cvc = cvc;
    }

    private void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    private void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private void setCountID(int countID) {
        this.countID = countID;
    }
}

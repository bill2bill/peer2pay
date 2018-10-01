package com.peer2pay.peer2pay.helperClasses.enums;

public enum MediaType {
    JSON("application/json; charset=utf-8"),
    URL_ENCODED("application/x-www-form-urlencoded");

    private final String value;

    MediaType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

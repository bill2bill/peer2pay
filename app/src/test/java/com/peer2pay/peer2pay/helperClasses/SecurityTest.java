package com.peer2pay.peer2pay.helperClasses;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {
    private Security security = new Security();
    private String key = "91BB9190ADE18C42BA01084AEE2F474D";

    @Test
    void oneWayHash() {
    }

    @Test
    void encrypt() {
        assertEquals("", security.encrypt(key, "bob"));
    }

    @Test
    void decrypt() {
    }
}
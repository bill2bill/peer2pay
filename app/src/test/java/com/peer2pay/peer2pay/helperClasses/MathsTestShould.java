package com.peer2pay.peer2pay.helperClasses;

import com.peer2pay.peer2pay.helperClasses.utils.Maths;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class MathsTestShould {
    private Maths maths = new Maths();

    @Test
    void lastCharacters() {
        assertEquals("4444", maths.lastCharacters(4, "33334444"));
    }

    @Test
    void lastCharacters_empty() {
        assertEquals("", maths.lastCharacters(4, ""));
    }

    @Test
    void lastCharacters_null() {
        assertEquals("", maths.lastCharacters(4, null));
    }

    @Test
    void lastCharacters_invlaid() {
        assertEquals("", maths.lastCharacters(4, "44"));
    }

    @Test
    void lastDigit() {
    }
}
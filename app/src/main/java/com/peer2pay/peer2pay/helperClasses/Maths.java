package com.peer2pay.peer2pay.helperClasses;

public class Maths {
    public String lastCharacters(int numChar, String word){
        return word != null && word.length() > numChar ? word.substring(word.length() - numChar) : "";
    }

    public int lastDigit(int numberOfDigits, int digit) { return (int) (digit % Math.pow(10, numberOfDigits)); }
}
